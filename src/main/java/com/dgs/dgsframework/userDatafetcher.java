package com.dgs.dgsframework;

import com.dgs.dgsframework.types.UserInfo;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import java.util.ArrayList;
import java.util.List;

@DgsComponent
public class userDatafetcher {

    @DgsQuery
    public List<UserInfo> getUserList(@InputArgument String usrKey) {
        List<UserInfo> result = new ArrayList<>();
        return result;
    }

    @DgsQuery
    public UserInfo getUserInfo(@InputArgument String usrKey) {
        return new UserInfo();
    }
}
