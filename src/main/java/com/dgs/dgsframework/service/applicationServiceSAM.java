package com.dgs.dgsframework.service;

import com.dgs.dgsframework.types.applicationDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class applicationServiceSAM implements applicationDetailService {
    @Override
    public boolean isModuleCheck(String module) {
        if ("SAM".equals(module)) {
            log.info("SAM");
            return true;
        }
        log.info("SAM X");
        return false;
    }

    @Override
    public boolean saveApplicationDetailItem(Long applicationKey, applicationDetail addApplicationDetail) {
        log.info("SAM 상세 내용 저장.");

        return false;
    }

    @Override
    public boolean saveApplicationApprovalDetailItem() {
        return false;
    }

    @Override
    public boolean saveApplicationCompanionDetailItem() {
        return false;
    }
}
