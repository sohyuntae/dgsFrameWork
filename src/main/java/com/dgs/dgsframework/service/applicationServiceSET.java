package com.dgs.dgsframework.service;

import com.dgs.dgsframework.types.applicationDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class applicationServiceSET implements applicationDetailService {
    @Override
    public boolean isModuleCheck(String module) {
        if ("SET".equals(module)) {
            log.info("SET");
            return true;
        }
        log.info("SET X");
        return false;
    }

    @Override
    public boolean saveApplicationDetailItem(Long applicationKey, applicationDetail addApplicationDetail) {
        log.info("SET 상세 내용 저장");
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
