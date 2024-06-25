package com.ohgiraffers.notimplement.product.model.dto;

public record DashBoardResponse(
        int allProductCount,
        int soldOutProductCount
) {
}
