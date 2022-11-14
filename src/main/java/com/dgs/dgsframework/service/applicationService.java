package com.dgs.dgsframework.service;

import com.dgs.dgsframework.types.*;

import java.util.List;

public interface applicationService {
    Long saveCommonApplication(applicationBasic addApplicationBasic);

    approvalInfo saveApprovalInfo(Long applicationKey, List<approval> addApproval, List<reference> addReference, List<approvalFile> addApprovalFile);
}
