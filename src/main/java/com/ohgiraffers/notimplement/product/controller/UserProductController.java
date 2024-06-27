package com.ohgiraffers.notimplement.product.controller;

import com.ohgiraffers.notimplement.product.model.dto.ProductResponse;
import com.ohgiraffers.notimplement.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@RequestMapping("/user")
@Controller
public class UserProductController {
    private final ProductService productService;

    public UserProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public String productList(Model model) {
        List<ProductResponse> products = productService.findAllProduct();
        model.addAttribute("products", products);
        return "userPage/product/productList";
    }

    @GetMapping("/product/{productId}")
    public String getProduct(@PathVariable int productId, Model model) {
        ProductResponse product = productService.getById(productId);
        model.addAttribute("product", product);

        var prices = IntStream.rangeClosed(1, 6)
                .map(it -> it * product.price())
                .boxed()
                .toList();
        model.addAttribute("prices", prices);
        return "userPage/product/product-details";
    }
}
