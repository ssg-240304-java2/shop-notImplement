package com.ohgiraffers.notimplement.user.model.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int getAvailablePoint(String userId);

    int getReturningPoint(String userId);

    int refundPoint(String userId, int getAvailablePoint, String point);

    void pointCharge(String userId, String point);
}
