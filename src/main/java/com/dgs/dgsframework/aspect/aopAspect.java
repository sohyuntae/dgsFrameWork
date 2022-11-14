package com.dgs.dgsframework.aspect;

import com.dgs.dgsframework.types.approvalInfo;
import com.dgs.dgsframework.types.processInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class aopAspect {
    private final com.dgs.dgsframework.service.approvalService approvalService;

    // exception이 발생하지 않고 정상적으로 실행된 경우, 실행.
    @AfterReturning(value = "@annotation(com.dgs.dgsframework.annotation.protocol)", returning = "protocolData")
    public void applicationProtocol(Object protocolData) {
        log.info("application Start");
        log.info("protocol data : " + protocolData);
    }

    // exception이 발생하지 않고 정상적으로 실행된 경우, 실행.
    @AfterReturning(value = "@annotation(com.dgs.dgsframework.annotation.approvalMessage)", returning = "approvalInfo")
    public void approvalProtocol(approvalInfo approvalInfo) {
        log.info("approval Start");
        log.info("approval message data : " + approvalInfo);

        if ("1".equals(approvalInfo.getApprovalWayCode())) {
            log.info("자가 결재");
            approvalService.saveApplicationApproval(approvalInfo);
        } else {
            log.info("결재x");
        }
        log.info("approval End");
    }

    // exception이 발생하지 않고 정상적으로 실행된 경우, 실행.
    @AfterReturning(value = "@annotation(com.dgs.dgsframework.annotation.processMessage)", returning = "processInfo")
    public void processProtocol(processInfo processInfo) {
        log.info("process Start");
        log.info("process message data : " + processInfo);

        log.info("자동 처리");

        log.info("process End");
    }
}
