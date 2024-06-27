package com.ohgiraffers.notimplement.user.model.service;

import com.ohgiraffers.notimplement.user.model.dao.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    private final UserMapper userMapper;

    @Override
    public int getAvailablePoint(String userId) {
        return userMapper.getAvailablePoint(userId);
    }

    @Override
    public int getReturningPoint(String userId) {
        return userMapper.getReturningPoint(userId);
    }

    @Override
    public int refundPoint(String userId, int getAvailablePoint, String point) {
        return userMapper.refundPoint(userId, getAvailablePoint, point);
    }

    @Override
    public void pointCharge(String userId, String point) {
        userMapper.pointCharge(userId, point);
    }
}
