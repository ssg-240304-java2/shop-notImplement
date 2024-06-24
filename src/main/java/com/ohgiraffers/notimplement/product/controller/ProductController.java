package com.ohgiraffers.notimplement.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @GetMapping("dashboard")
    public String productDashboard() {
        log.info("dashboard In");
        return "adminPage/product/productDashboard";
    }

    @GetMapping("list")
    public String productList() {
        log.info("list In");
        return "adminPage/product/productList";
    }
}
