package com.ohgiraffers.notimplement.product.model.dto;

public record ProductUpdateRequest(
        int categoryId,
        String brand,
        String name,
        Integer price,
        Integer amount,
        String description
) {
    public static final ProductUpdateRequest EMPTY = new ProductUpdateRequest(
            0,
            "",
            "",
            null,
            null,
            ""
    );
}
