package com.dgs.dgsframework;

import com.dgs.dgsframework.domain.Qusr_info;
import com.dgs.dgsframework.domain.usr_info;
import com.dgs.dgsframework.types.UserInfo;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
@RequiredArgsConstructor
public class userDatafetcher {

    private final JPAQueryFactory queryFactory;

    @Transactional(readOnly = true)
    @DgsData(parentType = DgsConstants.USERQUERY.TYPE_NAME)
    public List<UserInfo> getUserList(@InputArgument String usrKey) {

        List<usr_info> usrDomainList = queryFactory
                .selectFrom(Qusr_info.usr_info)
                .fetch();

        return usrDomainList
                .stream()
                .map(domain -> {
                    UserInfo userInfo = new UserInfo();
                    userInfo.setUid(domain.getUiId());
                    userInfo.setUserName(domain.getUiNm());
                    userInfo.setUserEmail(domain.getEmail());
                    return userInfo;
                }).collect(Collectors.toList());
    }

    @DgsData(parentType = DgsConstants.USERQUERY.TYPE_NAME)
    public UserInfo getUserInfo(@InputArgument String usrKey) {
        return new UserInfo();
    }
}
