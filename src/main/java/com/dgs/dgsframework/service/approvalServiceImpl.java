package com.dgs.dgsframework.service;

import com.dgs.dgsframework.annotation.processMessage;
import com.dgs.dgsframework.domain.testApplication;
import com.dgs.dgsframework.types.approvalInfo;
import com.dgs.dgsframework.types.processInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class approvalServiceImpl implements approvalService {

    private final com.dgs.dgsframework.repository.testApplicationRepository testApplicationRepository;

    public approvalServiceImpl(com.dgs.dgsframework.repository.testApplicationRepository testApplicationRepository) {
        this.testApplicationRepository = testApplicationRepository;
    }

    @Override
    @processMessage
    public processInfo saveApplicationApproval(approvalInfo addApproval) {
        // 실패시 이전 신청 내용까지 트랜잭션으로 묶임.
        processInfo processInfo = new processInfo();

        log.info("결재 요청.");
        if("1".equals(addApproval.getApprovalWayCode())) {
            processInfo = saveApplicationApprovalByUserKey();
        } else {
            processInfo = saveApplicationApprovalByAdminKey();
        }
        return processInfo;
    }

    // 신청 결재 저장 (결재자 : 사용자)
    public processInfo saveApplicationApprovalByUserKey() {
        log.info("사용자 결재 저장");
        testApplication insertData = new testApplication();
        insertData.setAppName("test");
        testApplicationRepository.save(insertData);

        processInfo processInfo = new processInfo();
        processInfo.setApplicationKey(1);
        processInfo.setProcessWayCode("1");
        processInfo.setProcessInfo(new ArrayList<>());

        return processInfo;
    }

    // 신청 결재 저장 (결재자 : 관리자)
    public processInfo saveApplicationApprovalByAdminKey() {
        log.info("관리자 결재 저장");

        processInfo processInfo = new processInfo();
        processInfo.setApplicationKey(1);
        processInfo.setProcessWayCode("1");
        processInfo.setProcessInfo(new ArrayList<>());
        return processInfo;
    }

}
