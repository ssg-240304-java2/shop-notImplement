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
                product.getSequence(),
                product.getCategoryCode(),
                product.getBrand(),
                product.getName(),
                product.getPrice(),
                product.getAmount(),
                product.getStatus().getTitle(),
                LocalDate.from(product.getRegDate()),
                Optional.ofNullable(product.getUpdateDate())
                        .map(LocalDate::from)
                        .orElse(null)
        );
    }
}
