package com.ohgiraffers.notimplement.product.controller;

import com.ohgiraffers.notimplement.product.model.dto.DashboardResponse;
import com.ohgiraffers.notimplement.product.model.dto.ProductRequest;
import com.ohgiraffers.notimplement.product.model.dto.ProductResponse;
import com.ohgiraffers.notimplement.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/product")
@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/dashboard")
    public String productDashboard(Model model) {
        DashboardResponse dashboardResponse = productService.showDashboard();

        model.addAttribute("dashboard", dashboardResponse);

        return "adminPage/product/productDashboard";
    }

    @GetMapping("/management")
    public String productList(Model model) {
        List<ProductResponse> products = productService.findAllProduct();

        model.addAttribute("products", products);

        return "adminPage/product/productManagement";
    }

    // 생성 view 페이지
    @GetMapping("/save")
    public String save(Model model) {
        model.addAttribute("categories", productService.getCategories());
        model.addAttribute("product", ProductRequest.EMPTY);
        return "adminPage/product/product-save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ProductRequest productRequest) {
        log.info("Saving product {}", productRequest);
        productService.saveProduct(productRequest);
        return "redirect:/product/management";
    }

    // 수정 view 페이지
    @GetMapping("/update")
    public String update() {
        return "adminPage/product/product-update";
    }

    //TODO: 수정 구현
    @PostMapping("/update")
    public String update(@ModelAttribute ProductRequest productRequest) {
        log.info("Updating product {}", productRequest);

        productService.update(productRequest);
        return "";
    }

    @GetMapping("/cancel")
    public String cancel() {
        return "redirect:/product/management";
    }

    @GetMapping("userlist")
    public String userProductList(Model model) {
        log.info("list In");
//        List<ProductResponse> userProducts = productService.findUserProduct();
        List<ProductResponse> userProducts = productService.findAllProduct();

        model.addAttribute("userProducts", userProducts);

        return "userPage/product/prouctList";
    }
}
