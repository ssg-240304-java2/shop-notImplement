package com.ohgiraffers.notimplement.user.controller;

import com.ohgiraffers.notimplement.user.model.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import java.io.IOException;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserService userService;
    private final View error;

    public UserController(UserService userService, View error) {
        this.userService = userService;
        this.error = error;
    }

    @GetMapping("/info")
    public String main() {
        return "userPage/userInfo";
    }


    @GetMapping("/point")
    public String point(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("id");

        // 데이터 베이스에서 고객의 사용 가능한 적립금 계산해서 반환
        int availablePoint = userService.getAvailablePoint(userId);
        model.addAttribute("availablePoint", availablePoint);

        int returningPoint = userService.getReturningPoint(userId);
        model.addAttribute("returningPoint", returningPoint);

        return "userPage/point/point";
    }

    @GetMapping("/pointRefund")
    public String pointRefund() {
        return "userPage/point/refund";
    }

    @GetMapping("/refundAmount")
    public String pointRefundAmount(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("id");

        int availablePoint = userService.getAvailablePoint(userId);

        model.addAttribute("availablePoint", availablePoint);

        return "userPage/point/refundAmount";
    }

    @PostMapping("refundPointConfirm")
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @ResponseBody
    public String pointRefund(@RequestParam String point, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("id");

        int result = userService.refundPoint(userId, userService.getAvailablePoint(userId), point);

        return "환급 성공";

    }

    @GetMapping("/pointCharge")
    public String pointCharge(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("id");

        int availablePoint = userService.getAvailablePoint(userId);
        model.addAttribute("availablePoint", availablePoint);
        return "userPage/point/charge";
    }

    @PostMapping("/Charge")
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @ResponseBody
    public String pointCharge(@RequestParam String point, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("id");

        userService.pointCharge(userId, point);

        return "적립금 충전 성공!!";
    }
}
