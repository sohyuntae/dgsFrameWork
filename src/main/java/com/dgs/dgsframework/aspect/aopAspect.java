package com.dgs.dgsframework.aspect;

import com.dgs.dgsframework.repository.testApplicationRepository;
import com.dgs.dgsframework.service.approvalService;
import com.dgs.dgsframework.service.approvalServiceImpl;
import com.dgs.dgsframework.types.approvalInfo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class aopAspect {

    // exception이 발생하지 않고 정상적으로 실행된 경우, 실행.
    @AfterReturning(value = "@annotation(com.dgs.dgsframework.annotation.protocol)", returning = "protocolData")
    public void applicationProtocol(Object protocolData) {
        log.info("application Start");
        log.info("protocol data : " + protocolData);
    }

    // exception이 발생하지 않고 정상적으로 실행된 경우, 실행.
    @AfterReturning(value = "@annotation(com.dgs.dgsframework.annotation.approvalProtocol)", returning = "approvalInfo")
    public void approvalProtocol(approvalInfo approvalInfo) {
        // approvalService approvalService = new approvalServiceImpl();
        log.info("approval Start");
        log.info("protocol data : " + approvalInfo);

        if ("1".equals(approvalInfo.getApprovalWayCode())) {
            log.info("자가 결재");
            // approvalService.saveApplicationApproval(approvalInfo);
        } else {
            log.info("결재x");
        }
    }
}
