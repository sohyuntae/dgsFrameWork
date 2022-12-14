package com.dgs.dgsframework;

import com.dgs.dgsframework.annotation.protocol;
import com.dgs.dgsframework.service.applicationDetailService;
import com.dgs.dgsframework.service.applicationService;
import com.dgs.dgsframework.service.applicationServiceSAM;
import com.dgs.dgsframework.service.applicationServiceSET;
import com.dgs.dgsframework.types.*;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@DgsComponent
public class applicationDatafetcher {

    private final applicationService applicationService;

    private final List<applicationDetailService> applicationDetailService;

    public applicationDatafetcher(
            applicationService applicationService,
            applicationServiceSET applicationServiceSET,
            applicationServiceSAM applicationServiceSAM
    )
    {
        // 신청
        this.applicationDetailService = new ArrayList<>();
        this.applicationService = applicationService;
        this.applicationDetailService.add(applicationServiceSET);
        this.applicationDetailService.add(applicationServiceSAM);
    }

    @DgsMutation
    @protocol
    @Transactional
    public String addApplication(
            @InputArgument applicationBasic addApplicationBasic,
            @InputArgument applicationDetail addApplicationDetail,
            @InputArgument List<addition> addAddition,
            @InputArgument List<approval> addApproval,
            @InputArgument List<reference> addReference,
            @InputArgument List<approvalFile> addApprovalFile
    ) {
        // 신청 공통
        Long applicationKey = applicationService.saveCommonApplication(addApplicationBasic);

        // 상세
        applicationDetailService
                .stream()
                .filter(item -> item.isModuleCheck(addApplicationDetail.getModule().name()))
                .forEach(service -> service.saveApplicationDetailItem(applicationKey, addApplicationDetail));

        // 결재 및 참조 내용 저장.
        applicationService.saveApprovalInfo(applicationKey, addApproval, addReference, addApprovalFile);

       return "성공";
    }
}
