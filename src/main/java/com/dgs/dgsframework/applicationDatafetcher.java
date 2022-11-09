package com.dgs.dgsframework;

import com.dgs.dgsframework.annotation.protocol;
import com.dgs.dgsframework.service.*;
import com.dgs.dgsframework.types.*;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@DgsComponent
public class applicationDatafetcher {

    private final applicationService applicationService;

    private final List<applicationDetailService> applicationDetailService;
    private final List<applicationProcessService> applicationProcessService;

    public applicationDatafetcher(
            applicationService applicationService,
            applicationServiceSET applicationServiceSET,
            applicationServiceSAM applicationServiceSAM,

            applicationProcessServiceSET applicationProcessServiceSET,
            applicationProcessServiceSAM applicationProcessServiceSAM
    )
    {
        // 신청
        this.applicationDetailService = new ArrayList<>();
        this.applicationService = applicationService;
        this.applicationDetailService.add(applicationServiceSET);
        this.applicationDetailService.add(applicationServiceSAM);

        // 처리
        this.applicationProcessService = new ArrayList<>();
        this.applicationProcessService.add(applicationProcessServiceSET);
        this.applicationProcessService.add(applicationProcessServiceSAM);
    }

    @DgsMutation
    @protocol
    @Transactional
    public String addApplication(
            @InputArgument applicationBasic addApplicationBasic,
            @InputArgument applicationDetail addApplicationDetail,
            @InputArgument List<addition> addAddition,
            @InputArgument List<approval> addApproval,
            @InputArgument List<reference> addReference
    ) {
        // 신청 공통
        Long applicationKey = applicationService.saveCommonApplication(addApplicationBasic);

        // 상세
        applicationDetailService
                .stream()
                .filter(item -> item.isModuleCheck(addApplicationDetail.getModule().name()))
                .forEach(service -> service.saveApplicationDetailItem(applicationKey, addApplicationDetail));

        // 결재 및 참조 내용 저장.
        applicationService.saveApprovalInfo(applicationKey, addApproval, addReference);

        // 결재

        // 처리
        /*applicationProcessService
                .stream()
                .filter(item -> item.isProcessCheck(addApplicationDetail.getModule().name()))
                .forEach(service -> service.saveProcess());*/

        return "성공";
    }
}
