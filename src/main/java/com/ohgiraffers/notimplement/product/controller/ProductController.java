package com.ohgiraffers.notimplement.product.controller;

import com.ohgiraffers.notimplement.product.model.dto.DashBoardResponse;
import com.ohgiraffers.notimplement.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product")
@Slf4j
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("dashboard")
    public String productDashboard(Model model) {
        log.info("dashboard In");
        DashBoardResponse dashBoardResponse = productService.showDashboard();
        int allProductCount = dashBoardResponse.allProductCount();
        int soldOutProductCount = dashBoardResponse.soldOutProductCount();

        int reservedProductCount = allProductCount - soldOutProductCount;

        model.addAttribute("allProductCount", allProductCount);
        model.addAttribute("soldOutProductCount",soldOutProductCount);
        model.addAttribute("reservedProductCount", reservedProductCount);

        return "adminPage/product/productDashboard";
    }

    @GetMapping("list")
    public String productList() {
        log.info("list In");
        return "adminPage/product/productList";
    }

    @GetMapping("userlist")
    public String userProductList() {
        log.info("list In");
        return "userPage/product/productList";
    }
}
