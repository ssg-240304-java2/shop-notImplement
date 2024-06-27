package com.ohgiraffers.notimplement.auth.model.service;

import com.ohgiraffers.notimplement.auth.model.dto.UserDTO;

import java.util.List;

public interface UserService {

    //signup
    void signup(UserDTO user);

    List<UserDTO> findAllUser();

    void delete(int userId);

    boolean login(String inId, String inPassword);

    //아이디중복체크
    boolean findUserById(String id);
}
