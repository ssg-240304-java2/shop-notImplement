package com.ohgiraffers.notimplement.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("login")
    public String login(@RequestParam String id) {
        log.info("login id is {}", id);
        if("1".equals(id)) {
            return "adminPage/main";
        }else{
            return "userPage/main";
        }
    }
}
