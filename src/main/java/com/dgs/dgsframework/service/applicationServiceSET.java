package com.dgs.dgsframework.service;

import com.dgs.dgsframework.common.CommonUtils;
import com.dgs.dgsframework.domain.application.sgn_rqst_stm;
import com.dgs.dgsframework.repository.sgnRqstStmRepository;
import com.dgs.dgsframework.types.applicationDetail;
import com.dgs.dgsframework.types.setDetailInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@Slf4j
@RequiredArgsConstructor
public class applicationServiceSET implements applicationDetailService {

    private final sgnRqstStmRepository sgnRqstStmRepository;

    @Override
    public boolean isModuleCheck(String module) {
        if ("SET".equals(module)) {
            log.info("SET");
            return true;
        }
        log.info("SET X");
        return false;
    }

    @Override
    public boolean saveApplicationDetailItem(Long applicationKey, applicationDetail addApplicationDetail) {
        log.info("SET 상세 내용 저장");

        try {
            setDetailInfo setDetailInfo = addApplicationDetail.getSetInfo();
            sgn_rqst_stm newInfo = new sgn_rqst_stm();
            newInfo.setSrKey(applicationKey); // 결재신청키
            newInfo.setSiKey(setDetailInfo.getSiKey()); // 시스템키
            newInfo.setGuKey(setDetailInfo.getSiUserKey()); // 시스템 소유자키
            newInfo.setStrtDt(CommonUtils.convertStringToTimestamp(setDetailInfo.getApplicationStartDate() + " 00:00:00", "yyyy-MM-dd HH:mm:ss")); // 시작일시
            newInfo.setEndDt(CommonUtils.convertStringToTimestamp(setDetailInfo.getApplicationEndDate() + " 00:00:00", "yyyy-MM-dd HH:mm:ss")); // 종료일시
            newInfo.setPrcsStCd("1"); // 처리상태코드
            newInfo.setRegDt(new Timestamp(java.lang.System.currentTimeMillis())); // 등록일시
            sgnRqstStmRepository.save(newInfo);
        } catch (Exception e) {
            e.printStackTrace();
            // 실패가 나는 경우, 강제 Exception 처리.
            throw new RuntimeException();
        }
        return true;
    }

    @Override
    public boolean saveApplicationApprovalDetailItem() {
        return false;
    }

    @Override
    public boolean saveApplicationCompanionDetailItem() {
        return false;
    }
}
