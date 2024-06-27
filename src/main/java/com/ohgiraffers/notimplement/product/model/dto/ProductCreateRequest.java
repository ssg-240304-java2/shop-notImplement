package com.ohgiraffers.notimplement.product.model.dto;

import com.ohgiraffers.notimplement.product.model.domain.Product;

import java.util.Objects;

public record ProductCreateRequest(
        int categoryId,
        String brand,
        String name,
        Integer price,
        Integer amount,
        String description
) {
    public static final ProductCreateRequest EMPTY = new ProductCreateRequest(
            0,
            "",
            "",
            null,
            null,
            ""
    );

    public Product toEntity() {
        return new Product(
                0,
                categoryId,
                brand,
                name,
                Objects.requireNonNullElse(price, 0),
                description,
                Objects.requireNonNullElse(amount, 0)
        );
    }
}
