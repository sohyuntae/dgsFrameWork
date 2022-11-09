package com.dgs.dgsframework.service;

import com.dgs.dgsframework.annotation.approvalProtocol;
import com.dgs.dgsframework.domain.Qstm_info;
import com.dgs.dgsframework.domain.QtestApplication;
import com.dgs.dgsframework.domain.testApplication;
import com.dgs.dgsframework.repository.testApplicationRepository;
import com.dgs.dgsframework.types.applicationBasic;
import com.dgs.dgsframework.types.approval;
import com.dgs.dgsframework.types.approvalInfo;
import com.dgs.dgsframework.types.reference;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class applicationServiceImpl implements applicationService {
    private final JPAQueryFactory queryFactory;

    private final testApplicationRepository testApplicationRepository;

    @Override
    public Long saveCommonApplication(applicationBasic addApplicationBasic) {
        log.info("신청 공통 정보 저장");

        testApplication insertData = new testApplication();
        insertData.setAppName("test");
        testApplicationRepository.save(insertData);

        return null;
    }

    @Override
    @approvalProtocol
    public approvalInfo saveApprovalInfo(Long applicationKey, List<approval> addApproval, List<reference> addReference) {
        log.info("결재 정보 저장");
        log.info("참조자 정보 저장");

        // 임시 내용저장.
        approvalInfo approvalInfo = new approvalInfo();
        approvalInfo.setApplicationKey(1);
        approvalInfo.setApprovalWayCode("1");
        approvalInfo.setApprovalInfo(new ArrayList<>());
        return approvalInfo;
    }
}
