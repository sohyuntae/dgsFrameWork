package com.dgs.dgsframework.service;

import com.dgs.dgsframework.types.applicationBasic;
import com.dgs.dgsframework.types.approval;
import com.dgs.dgsframework.types.approvalInfo;
import com.dgs.dgsframework.types.reference;

import java.util.List;

public interface applicationService {
    Long saveCommonApplication(applicationBasic addApplicationBasic);

    approvalInfo saveApprovalInfo(Long applicationKey, List<approval> addApproval, List<reference> addReference);
}
