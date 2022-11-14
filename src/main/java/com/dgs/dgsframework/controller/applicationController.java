package com.dgs.dgsframework.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class applicationController {

    @RequestMapping(value = "/testAop")
    public boolean testApplicationCall(HttpServletRequest request, HttpServletResponse response) {
        log.info("test");
        return false;
    }
}
