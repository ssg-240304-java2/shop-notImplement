package com.ohgiraffers.notimplement.user.model.service;

import com.ohgiraffers.notimplement.user.model.dao.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    private final UserMapper userMapper;

    @Override
    public int getAvailablePoint(int userId) {
        return userMapper.getAvailablePoint(userId);
    }
}
