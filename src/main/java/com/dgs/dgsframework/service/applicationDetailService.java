package com.dgs.dgsframework.service;

// 결재 관련 인터페이스
public interface applicationDetailService {
    // 신청 상세 저장
    boolean saveApplicationDetailItem();
    // 상세 결재 저장(승인)
    boolean saveApplicationApprovalDetailItem();
    // 상세 결재 저장(반려)
    boolean saveApplicationCompanionDetailItem();
}
