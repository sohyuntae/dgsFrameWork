package com.dgs.dgsframework.service;

import com.dgs.dgsframework.types.approvalInfo;
import com.dgs.dgsframework.types.processInfo;

public interface approvalService {

    processInfo saveApplicationApproval(approvalInfo addApproval);
}
