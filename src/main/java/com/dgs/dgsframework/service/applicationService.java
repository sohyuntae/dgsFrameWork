package com.dgs.dgsframework.service;

import com.dgs.dgsframework.types.applicationBasic;

public interface applicationService {
    Long saveCommonApplication(applicationBasic addApplicationBasic);

    boolean saveApplicationApproval();
}
