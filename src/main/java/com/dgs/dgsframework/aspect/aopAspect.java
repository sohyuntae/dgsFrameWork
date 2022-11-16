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
        /* 처리 관련 데이터 처리
        * 1. NH80에 API 생성 및 직접 결재 데이터 전달
        *   - 두개의 서버중 하나의 서버가 죽는 경우, 문제 발생.
        * 2. 중간에 message Service를 하나 두고 서로 통신하도록 하는 방법
        *   - 현재 가장 가능성이 높으나. 구현에 있어서 내용을 좀 더 자세히 확인한뒤에 사용해야 할것으로 판단됨.
        * 3. DB를 이용하는 방식.
        *   - 결재가 완료된 데이터에 대해서 DB에 업데이트를 하고 일정시간이 되면 NH80에서 처리하는 방식 가능.
        * */

        log.info("process End");
    }
}
