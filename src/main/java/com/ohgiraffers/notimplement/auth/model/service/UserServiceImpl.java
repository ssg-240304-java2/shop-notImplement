package com.ohgiraffers.notimplement.auth.model.service;

import com.ohgiraffers.notimplement.auth.model.dao.authMapper;
import com.ohgiraffers.notimplement.auth.model.dto.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    public UserServiceImpl(authMapper authMapper) {
        this.authMapper = authMapper;
    }

    private final authMapper authMapper;

    @Override
    @Transactional
    public void signup(UserDTO user) {
        authMapper.signup(user);
    }



    @Override
    public List<UserDTO> findAllUser() {
        System.out.println(authMapper.findAllUser());
        return authMapper.findAllUser();
    }

    @Override
    public void delete(int userId) {
        authMapper.delete(userId);
    }

    @Override
    public boolean login(String inId, String inPassword) {
        System.out.println(authMapper.login(inId, inPassword));
        if(authMapper.login(inId, inPassword) > 0){
            return true;

        }
        System.out.println(authMapper.login(inId, inPassword));
        return false;
    }

    @Override
    public boolean findUserById(String id) {
        System.out.println(authMapper.findUserById(id));
        return authMapper.findUserById(id) <= 0 ? true : false;
    }
}
