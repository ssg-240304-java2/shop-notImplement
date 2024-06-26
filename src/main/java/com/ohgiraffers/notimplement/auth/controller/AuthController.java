package com.ohgiraffers.notimplement.auth.controller;

import com.ohgiraffers.notimplement.board.model.service.InquiryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/auth")
public class AuthController {

    private final InquiryService inquiryService;

    public AuthController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }


    @GetMapping("login")
    public String login(@RequestParam String id) {
        log.info("login id is {}", id);
        if("1".equals(id)) {
            return "redirect:/auth/admin/main";
        }else{
            return "userPage/main";
        }
    }

    @GetMapping("/admin/main")
    public String adminMain(Model model){
        int countInquiry = inquiryService.getCountNotAnswer();
        model.addAttribute("countInquiry",countInquiry);
        return "adminPage/main";
    }

}
