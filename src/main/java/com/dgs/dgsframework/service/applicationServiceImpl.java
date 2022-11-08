package com.dgs.dgsframework.service;

import com.dgs.dgsframework.types.applicationBasic;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class applicationServiceImpl implements applicationService {
    private final JPAQueryFactory queryFactory;

    @Override
    public Long saveCommonApplication(applicationBasic addApplicationBasic) {
        return null;
    }

    @Override
    public boolean saveApplicationApproval() {
        return false;
    }

    // 신청 결재 저장 (결재자 : 사용자)
    public boolean saveApplicationApprovalByUserKey() {
        return false;
    }

    // 신청 결재 저장 (결재자 : 관리자)
    public boolean saveApplicationApprovalByAdminKey() {
        return false;
    }
}
