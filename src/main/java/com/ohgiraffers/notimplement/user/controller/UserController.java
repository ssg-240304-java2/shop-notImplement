package com.ohgiraffers.notimplement.user.controller;

import com.ohgiraffers.notimplement.user.model.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/info")
    public String main() {
        return "userPage/userInfo";
    }


    @GetMapping("/point")
    public String point(Model model) {

        int userId = 1;

        // 데이터 베이스에서 고객의 사용 가능한 적립금 계산해서 반환
        int availablePoint = userService.getAvailablePoint(userId);

        model.addAttribute("availablePoint", availablePoint);
        return "userPage/point/point";
    }
}
