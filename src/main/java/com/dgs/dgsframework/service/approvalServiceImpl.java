package com.dgs.dgsframework.service;

import com.dgs.dgsframework.annotation.processMessage;
import com.dgs.dgsframework.common.CommonUtils;
import com.dgs.dgsframework.domain.Qnh_adm_info;
import com.dgs.dgsframework.domain.application.Qsgn_rqst;
import com.dgs.dgsframework.domain.application.Qsgn_sttn;
import com.dgs.dgsframework.domain.application.sgn_rqst;
import com.dgs.dgsframework.domain.application.sgn_sttn;
import com.dgs.dgsframework.domain.nh_adm_info;
import com.dgs.dgsframework.repository.sgnRqstRepository;
import com.dgs.dgsframework.repository.sgnSttnRepository;
import com.dgs.dgsframework.types.approvalInfo;
import com.dgs.dgsframework.types.processInfo;
import com.dgs.dgsframework.types.saveApprovalInfo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class approvalServiceImpl implements approvalService {

    private final JPAQueryFactory queryFactory;
    private final sgnRqstRepository sgnRqstRepository;
    private final sgnSttnRepository sgnSttnRepository;

    @Override
    @processMessage
    public processInfo saveApplicationApproval(approvalInfo addApproval) {
        // 실패시 이전 신청 내용까지 트랜잭션으로 묶임.
        log.info("결재 요청.");
        processInfo processInfo = new processInfo();
        List<Long> applicationKeyList = new ArrayList<>();
        applicationKeyList.add(addApproval.getApplicationKey());

        saveApprovalInfo saveApproval = new saveApprovalInfo();
        saveApproval.setApplicationKey(applicationKeyList);
        saveApproval.setApprovalStatusCode("3");

        if ("1".equals(addApproval.getRequestUserTypeCode())) {
            saveApproval.setApprovalReason("자가 결재");
            processInfo = saveApplicationApprovalByUserKey(saveApproval, addApproval.getApplicationKey());
        } else {
            saveApproval.setApprovalReason("관리자 등록");
            processInfo = saveApplicationApprovalByAdminKey(saveApproval, addApproval.getApplicationKey());
        }
        return processInfo;
    }

    // 신청 결재 저장 (결재자 : 사용자)
    public processInfo saveApplicationApprovalByUserKey(saveApprovalInfo saveApproval, Long adminKey) {
        log.info("사용자 결재 저장");

        // 신청키 리스트
        List<Long> requestKeyList = saveApproval.getApplicationKey();

        // 결재 완료 결재키 리스트
        List<Long> completeRequestKeyList = new ArrayList<>();

        List<sgn_sttn> findApprovalInfoList = queryFactory
                .selectFrom(Qsgn_sttn.sgn_sttn)
                .where(Qsgn_sttn.sgn_sttn.srKey.in(saveApproval.getApplicationKey()))
                .orderBy(Qsgn_sttn.sgn_sttn.sgnStp.asc())
                .fetch();

        Map<Long, List<sgn_sttn>> approvalInfoListMap = CommonUtils.listGroupBy(findApprovalInfoList, sgn_sttn::getSrKey);
        requestKeyList.forEach(key -> {
            List<sgn_sttn> approvalInfoList = approvalInfoListMap.get(key);
            if (approvalInfoList == null || approvalInfoList.size() < 1) return;

            // 현재 결재 대상자가 자신이 아니면 리턴 (필터조건 : 사용자타입이면서 결재자가 자신인 대상 조회)
            sgn_sttn currentApprTarget = approvalInfoList.stream()
                    .filter(app -> "1".equals(app.getSgnrDvsCd()) && (Objects.equals(app.getSgnrKey(), adminKey)))
                    .findFirst()
                    .orElse(null);
            if (currentApprTarget == null) return;

            // 다음 결재자 조회 (현재 결재 대상자 step 보다 큰 대상자 중에 가장 처음 결재자 찾기)
            // null 이어도 됨 (현재 결재자가 마지막 결재자인 경우)
            sgn_sttn nextApprTarget = approvalInfoList.stream()
                    .filter(app -> app.getSgnStp() > currentApprTarget.getSgnStp())
                    .findFirst()
                    .orElse(null);

            // 신청 상태값 변경.
            sgn_rqst sgnRqstDomain = queryFactory
                    .selectFrom(Qsgn_rqst.sgn_rqst)
                    .where(Qsgn_rqst.sgn_rqst.srKey.eq(currentApprTarget.getSrKey()))
                    .fetchFirst();

            sgnRqstDomain.setSgnStCd("2");
            sgnRqstRepository.save(sgnRqstDomain);

            currentApprTarget.setSgnRsn(saveApproval.getApprovalReason());
            currentApprTarget.setSgnStCd(saveApproval.getApprovalStatusCode());
            currentApprTarget.setSgnDt(new Timestamp(System.currentTimeMillis()));
            sgnSttnRepository.save(currentApprTarget);

            if (nextApprTarget != null) {
                nextApprTarget.setSgnStCd("1");
                sgnSttnRepository.save(nextApprTarget);
            }

            // 반려일 경우 혹은 마지막 결재일 경우 신청 테이블에 상태값 갱신
            if (Objects.equals(saveApproval.getApprovalStatusCode(), "4") || nextApprTarget == null) {
                sgn_rqst lastSgnRqstDomain = queryFactory
                        .selectFrom(Qsgn_rqst.sgn_rqst)
                        .where(Qsgn_rqst.sgn_rqst.srKey.eq(key))
                        .fetchFirst();
                if (lastSgnRqstDomain != null) {
                    lastSgnRqstDomain.setSgnStCd(saveApproval.getApprovalStatusCode());
                    sgnRqstRepository.save(lastSgnRqstDomain);
                }
                completeRequestKeyList.add(key);
            }

            // 처리 여부에 대한 내용을 적어서 리턴해야한다.
        });

        return new processInfo();
    }

    // 신청 결재 저장 (결재자 : 관리자)
    public processInfo saveApplicationApprovalByAdminKey(saveApprovalInfo saveApproval, Long adminKey) {
        log.info("관리자 결재 저장");

        // 신청키 리스트
        List<Long> requestKeyList = saveApproval.getApplicationKey();

        // 결재 완료 결재키 리스트
        List<Long> completeRequestKeyList = new ArrayList<>();

        // 관리자 정보
        nh_adm_info nhAdmInfo = queryFactory
            .selectFrom(Qnh_adm_info.nh_adm_info)
            .where(Qnh_adm_info.nh_adm_info.naiKey.eq(adminKey))
            .fetchFirst();

        // 전결자일경우 내용 적용
        // String adminNote = "대결자 : " + nhAdmInfo.getNaiNm() + " / " + saveApproval.getApprovalReason();

        // 결재상황 (대기 진행만 가져오기)
        List<sgn_sttn> findApprovalInfoList = queryFactory
            .selectFrom(Qsgn_sttn.sgn_sttn)
            .where(Qsgn_sttn.sgn_sttn.srKey.in(saveApproval.getApplicationKey()))
            .orderBy(Qsgn_sttn.sgn_sttn.sgnStp.asc())
            .fetch();

        Map<Long, List<sgn_sttn>> approvalInfoListMap = CommonUtils.listGroupBy(findApprovalInfoList, sgn_sttn::getSrKey);

        requestKeyList.forEach(key -> {

        });

        return new processInfo();
    }

}
