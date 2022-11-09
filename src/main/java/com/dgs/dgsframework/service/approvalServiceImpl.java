package com.dgs.dgsframework.service;

import com.dgs.dgsframework.annotation.approvalProtocol;
import com.dgs.dgsframework.domain.testApplication;
import com.dgs.dgsframework.types.approvalInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class approvalServiceImpl implements approvalService {

    private final com.dgs.dgsframework.repository.testApplicationRepository testApplicationRepository;

    public approvalServiceImpl() {
        testApplicationRepository = null;
    }

    public approvalServiceImpl(com.dgs.dgsframework.repository.testApplicationRepository testApplicationRepository) {
        this.testApplicationRepository = testApplicationRepository;
    }

    @Override
    public boolean saveApplicationApproval(approvalInfo addApproval) {
        log.info("결재 요청.");
        if("1".equals(addApproval.getApprovalWayCode())) {
            saveApplicationApprovalByUserKey();
        } else {
            saveApplicationApprovalByAdminKey();
        }
        return false;
    }

    // 신청 결재 저장 (결재자 : 사용자)
    @Transactional
    public boolean saveApplicationApprovalByUserKey() {
        try {
            log.info("사용자 결재 저장");
            testApplication insertData = new testApplication();
            insertData.setAppName("test");
            testApplicationRepository.save(insertData);
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 신청 결재 저장 (결재자 : 관리자)
    @approvalProtocol
    public boolean saveApplicationApprovalByAdminKey() {
        log.info("관리자 결재 저장");
        return false;
    }

}
