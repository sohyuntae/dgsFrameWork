package com.dgs.dgsframework.service;

import com.dgs.dgsframework.annotation.approvalMessage;
import com.dgs.dgsframework.domain.application.*;
import com.dgs.dgsframework.domain.testApplication;
import com.dgs.dgsframework.repository.*;
import com.dgs.dgsframework.types.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class applicationServiceImpl implements applicationService {
    private final JPAQueryFactory queryFactory;

    private final sgnRqstRepository sgnRqstRepository;
    private final sgnSttnRepository sgnSttnRepository;
    private final sgnAtchRefRepository sgnAtchRefRepository;
    private final sgnRqstFileRepository sgnRqstFileRepository;

    @Override
    public Long saveCommonApplication(applicationBasic addApplicationBasic) {
        log.info("신청 공통 정보 저장");
        sgn_rqst newInfo = new sgn_rqst();
        newInfo.setSrKey(addApplicationBasic.getSrKey());
        newInfo.setCgcCd(addApplicationBasic.getModuleCode());
        newInfo.setCdcCd(addApplicationBasic.getCategoryCode());
        newInfo.setRqstStCd(addApplicationBasic.getApplicationStatusCode());
        newInfo.setPrcsStCd("1");
        newInfo.setSgnStCd("1");
        newInfo.setRqstrDvsCd(addApplicationBasic.getRequestUserTypeCode());
        newInfo.setRqstUsrKey(addApplicationBasic.getRequestUserKey());
        newInfo.setSgnWayCd(addApplicationBasic.getPaymentMethodCode()); // 결재방법코드 (환경설정)
        newInfo.setPrcsWayCd(addApplicationBasic.getProcessingMethodCode()); // 처리방식코드 (환경설정)
        newInfo.setSrNm(addApplicationBasic.getApplicationTitle());
        newInfo.setRqstRsn(addApplicationBasic.getApplicationContent());
        newInfo.setRqstDt(new Timestamp(java.lang.System.currentTimeMillis()));
        newInfo.setRegrDvsCd(addApplicationBasic.getRegistrarTypeCode()); // 등록자 구분코드 (관리자 2)
        newInfo.setRegKey(addApplicationBasic.getRegistrarKey());
        newInfo.setMnlRegYn(!Optional.ofNullable(addApplicationBasic.getManualRegYn()).orElse("").isEmpty() ? addApplicationBasic.getManualRegYn() : "0");
        // 임시 adminType에 따라서 데이터를 넣을때 사용자로 넘어오는 경우, 고정값으로 처리
        if ("1".equals(addApplicationBasic.getRegistrarTypeCode())) {
            newInfo.setPrcsrDvsCd("2");
            newInfo.setPrcsAdmKey(1L);
        } else {
            newInfo.setPrcsrDvsCd(addApplicationBasic.getRegistrarTypeCode());
            newInfo.setPrcsAdmKey(addApplicationBasic.getRegistrarKey());
        }

        sgn_rqst newApplicationInfo = sgnRqstRepository.save(newInfo);

        return newApplicationInfo.getSrKey();
    }

    @Override
    @approvalMessage
    public approvalInfo saveApprovalInfo(
            Long applicationKey,
            List<approval> addApproval,
            List<reference> addReference,
            List<approvalFile> addApprovalFile
    ) {
        log.info("결재 정보 저장");
        addApproval.forEach(approval -> {
            sgn_sttn newStatus = new sgn_sttn();
            newStatus.setSrKey(applicationKey);
            newStatus.setSgnrKey(approval.getApplicantKey());
            newStatus.setSgnrDvsCd(approval.getApplicantDivisionCode());
            newStatus.setSgnStp(approval.getApprovalStep());
            newStatus.setSgnStCd(approval.getApprovalStep() == 1 ? "1" : "2");
            sgnSttnRepository.save(newStatus);
        });

        log.info("참조자 정보 저장");
        addReference.forEach(reference -> {
            sgn_atch_rfr newStatus = new sgn_atch_rfr();
            newStatus.setSrKey(applicationKey);
            newStatus.setSarKey(reference.getReferenceKey());
            newStatus.setSarDvsCd(reference.getReferenceDivisionCode());
            newStatus.setRegDt(new Timestamp(java.lang.System.currentTimeMillis()));
            sgnAtchRefRepository.save(newStatus);
        });

        log.info("결재 신청 첨부파일 저장");
        addApprovalFile.forEach(approvalFile -> {
            sgn_rqst_file newFile = new sgn_rqst_file();
            newFile.setSrKey(applicationKey);
            newFile.setFilePath(approvalFile.getFilePath());
            newFile.setRegDt(new Timestamp(java.lang.System.currentTimeMillis()));
            newFile.setSizeKb(approvalFile.getFileSize());
        });

        // 자가 결재인지 여부를 파악 해야함.
        // 결재 상세 정보를 넣어야함.
        sgn_rqst requestInfo = queryFactory
                .selectFrom(Qsgn_rqst.sgn_rqst)
                .where(Qsgn_rqst.sgn_rqst.srKey.eq(applicationKey))
                .fetchFirst();

        // 임시 내용저장.
        approvalInfo approvalInfo = new approvalInfo();
        approvalInfo.setApplicationKey(applicationKey);
        approvalInfo.setApprovalWayCode(requestInfo.getSgnWayCd());
        approvalInfo.setManualRegYn(requestInfo.getMnlRegYn());
        approvalInfo.setRequestUserTypeCode(requestInfo.getRqstrDvsCd());
        approvalInfo.setRequestUserKey(requestInfo.getRqstUsrKey());
        return approvalInfo;
    }
}
