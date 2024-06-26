package com.ohgiraffers.notimplement.product.model.dto;

import com.ohgiraffers.notimplement.product.model.domain.Product;

import java.time.LocalDate;
import java.util.Optional;

public record ProductResponse(
        int productSeq,
        int categoryCode,
        String productBrand,
        String productName,
        int productPrice,
        int productAmount,
        String productStatus,
        LocalDate regDate,
        LocalDate updateDate
) {
    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getProductSeq(),
                product.getCategoryCode(),
                product.getProductBrand(),
                product.getProductName(),
                product.getProductPrice(),
                product.getProductAmount(),
                product.getProductStatus().getTitle(),
                LocalDate.from(product.getRegDate()),
                Optional.ofNullable(product.getUpdateDate())
                        .map(LocalDate::from)
                        .orElse(null)
        );
    }
}
