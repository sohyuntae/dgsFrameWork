package com.dgs.dgsframework.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class applicationServiceImpl implements applicationService {
    private final JPAQueryFactory queryFactory;

    @Override
    public Long saveCommonApplication() {
        return null;
    }
}
