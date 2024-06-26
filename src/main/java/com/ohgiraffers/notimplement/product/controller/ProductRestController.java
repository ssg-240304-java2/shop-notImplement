package com.ohgiraffers.notimplement.product.controller;

import com.ohgiraffers.notimplement.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductRestController {
    private final ProductService productService;

    @DeleteMapping("/products/{productId}")
    public void delete(@PathVariable long productId) {
        productService.delete(productId);
    }
}
