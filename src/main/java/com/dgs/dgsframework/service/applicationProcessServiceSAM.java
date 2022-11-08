package com.dgs.dgsframework.service;

import org.springframework.stereotype.Service;

@Service
public class applicationProcessServiceSAM implements applicationProcessService {
    @Override
    public boolean isProcessCheck(String module) {
        return "SAM".equals(module);
    }

    @Override
    public boolean saveProcess() {
        return false;
    }
}
