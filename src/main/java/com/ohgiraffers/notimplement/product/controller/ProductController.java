package com.ohgiraffers.notimplement.product.controller;

import com.ohgiraffers.notimplement.product.model.domain.Product;
import com.ohgiraffers.notimplement.product.model.dto.DashboardResponse;
import com.ohgiraffers.notimplement.product.model.dto.ProductResponse;
import com.ohgiraffers.notimplement.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.format.DateTimeFormatter;
import java.util.List;

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
        DashboardResponse dashboardResponse = productService.showDashboard();
        int allProductCount = dashboardResponse.allProductCount();
        int soldOutProductCount = dashboardResponse.soldOutProductCount();

        int reservedProductCount = allProductCount - soldOutProductCount;

        model.addAttribute("allProductCount", allProductCount);
        model.addAttribute("soldOutProductCount",soldOutProductCount);
        model.addAttribute("reservedProductCount", reservedProductCount);

        return "adminPage/product/productDashboard";
    }

    @GetMapping("/management")
    public String productList(Model model) {
        List<ProductResponse> products = productService.findAllProduct();

        model.addAttribute("products", products);

        return "adminPage/product/productManagement";
    }


    @GetMapping("userlist")
    public String userProductList() {
        log.info("list In");
        return "userPage/product/productList";
    }
}
