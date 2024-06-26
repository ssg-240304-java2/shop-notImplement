package com.ohgiraffers.notimplement.product.controller;

import com.ohgiraffers.notimplement.product.model.dto.DashboardResponse;
import com.ohgiraffers.notimplement.product.model.dto.ProductCreateRequest;
import com.ohgiraffers.notimplement.product.model.dto.ProductResponse;
import com.ohgiraffers.notimplement.product.model.dto.ProductUpdateRequest;
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

    @GetMapping("/save")
    public String save(Model model) {
        model.addAttribute("categories", productService.getCategories());
        model.addAttribute("product", ProductCreateRequest.EMPTY);
        return "adminPage/product/product-save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ProductCreateRequest request) {
        log.info("Saving product {}", request);
        productService.saveProduct(request);
        return "redirect:/product/management";
    }

    @GetMapping("/{productId}/update")
    public String update(@PathVariable int productId, Model model) {
        ProductResponse response = productService.getById(productId);

        model.addAttribute("categories", productService.getCategories());
        model.addAttribute("productResponse", response);
        model.addAttribute("productRequest", ProductUpdateRequest.EMPTY);
        return "adminPage/product/product-update";
    }

    @PostMapping("/{productId}/update")
    public String update(
            @PathVariable int productId,
            @ModelAttribute ProductUpdateRequest request
    ) {
        log.info("Updating product {}", request);
        productService.update(productId, request);
        return "redirect:/product/management";
    }
}
