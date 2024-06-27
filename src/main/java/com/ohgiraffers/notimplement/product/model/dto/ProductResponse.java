package com.ohgiraffers.notimplement.product.model.dto;

import com.ohgiraffers.notimplement.product.model.domain.Product;

import java.time.LocalDate;
import java.util.Optional;

public record ProductResponse(
        int sequence,
        int categoryCode,
        String brand,
        String name,
        int price,
        int amount,
        String status,
        String description,
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
                product.getDescription(),
                LocalDate.from(product.getRegDate()),
                Optional.ofNullable(product.getUpdateDate())
                        .map(LocalDate::from)
                        .orElse(null)
        );
    }
}
