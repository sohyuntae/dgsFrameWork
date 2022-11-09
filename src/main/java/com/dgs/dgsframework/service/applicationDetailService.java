package com.dgs.dgsframework.service;

import com.dgs.dgsframework.types.applicationDetail;

// 결재 관련 인터페이스
public interface applicationDetailService {
    boolean isModuleCheck(String module);
    // 신청 상세 저장
    boolean saveApplicationDetailItem(Long applicationKey, applicationDetail addApplicationDetail);
    // 상세 결재 저장(승인)
    boolean saveApplicationApprovalDetailItem();
    // 상세 결재 저장(반려)
    boolean saveApplicationCompanionDetailItem();
}
