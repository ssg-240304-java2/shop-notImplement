package com.ohgiraffers.notimplement.user.model.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int getAvailablePoint(int userId);

    int refundPoint(int userId, int getAvailablePoint, String point);
}
