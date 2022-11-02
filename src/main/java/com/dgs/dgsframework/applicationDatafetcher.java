package com.dgs.dgsframework;

import com.dgs.dgsframework.domain.Qusr_info;
import com.dgs.dgsframework.domain.usr_info;
import com.dgs.dgsframework.types.*;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
@RequiredArgsConstructor
public class applicationDatafetcher {

    private final JPAQueryFactory queryFactory;

    @DgsMutation
    @Transactional
    public String addApplication(
            @InputArgument applicationBasic addApplicationBasic,
            @InputArgument applicationDetail addApplicationDetail,
            @InputArgument List<addition> addAddition,
            @InputArgument List<approval> addApproval,
            @InputArgument List<reference> addReference
    ) {

        return "성공~!";
    }
}
