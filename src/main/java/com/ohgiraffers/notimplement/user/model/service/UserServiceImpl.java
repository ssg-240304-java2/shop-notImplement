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
    public int getAvailablePoint(int userId) {
        return userMapper.getAvailablePoint(userId);
    }

    @Override
    public int getReturningPoint(int userId) {
        return userMapper.getReturningPoint(userId);
    }
  
    @Override
    public int refundPoint(int userId, int getAvailablePoint, String point) {
        return userMapper.refundPoint(userId, getAvailablePoint, point);
    }
}
