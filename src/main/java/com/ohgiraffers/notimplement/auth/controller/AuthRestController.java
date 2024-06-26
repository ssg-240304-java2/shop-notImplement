package com.ohgiraffers.notimplement.auth.controller;

import com.ohgiraffers.notimplement.auth.model.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthRestController {
    private final UserService userService;

    @DeleteMapping("/userList/{userId}")
    public void deleteUser(@PathVariable int userId){
        userService.delete(userId);
    }
}
