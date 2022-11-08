package com.dgs.dgsframework.aspect;

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
        log.info("application Protocol Start");

        log.info("protocol data : " + protocolData);


    }
}
