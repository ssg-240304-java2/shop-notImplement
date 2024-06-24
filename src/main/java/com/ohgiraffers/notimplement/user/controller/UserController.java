package com.ohgiraffers.notimplement.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/user")
public class UserController {

    @GetMapping("/main")
    public String main() {
        return "userPage/main";
    }
}
