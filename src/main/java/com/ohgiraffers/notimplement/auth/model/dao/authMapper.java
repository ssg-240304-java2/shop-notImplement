package com.ohgiraffers.notimplement.auth.model.dao;

import com.ohgiraffers.notimplement.auth.model.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface authMapper {

    void signup(UserDTO user);

    List<UserDTO> findAllUser();

    void delete(int userId);

    int login(String inId, String inPassword);

    int findUserById(String id);
}
