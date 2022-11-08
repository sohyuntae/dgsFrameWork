package com.dgs.dgsframework.service;

import org.springframework.stereotype.Service;

@Service
public class applicationProcessServiceSET implements applicationProcessService {
    @Override
    public boolean isProcessCheck(String module) {
        return "SET".equals(module);
    }

    @Override
    public boolean saveProcess() {
        return false;
    }
}
