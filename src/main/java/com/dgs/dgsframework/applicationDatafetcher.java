package com.dgs.dgsframework;

import com.dgs.dgsframework.service.applicationDetailService;
import com.dgs.dgsframework.types.*;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@DgsComponent
@RequiredArgsConstructor
public class applicationDatafetcher {

    private final com.dgs.dgsframework.service.applicationService applicationService;
    private final com.dgs.dgsframework.service.applicationDetailService applicationDetailService;

    @DgsMutation
    @Transactional
    public String addApplication(
            @InputArgument applicationBasic addApplicationBasic,
            @InputArgument applicationDetail addApplicationDetail,
            @InputArgument List<addition> addAddition,
            @InputArgument List<approval> addApproval,
            @InputArgument List<reference> addReference
    ) {

        // 공통
        Long applicationKey = applicationService.saveCommonApplication();
        // 상세
        applicationDetailService.saveApplicationDetailItem();
        // 처리



        return "";
    }
}
