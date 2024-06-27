package com.ohgiraffers.notimplement.product.model.dto;

public record DashboardResponse(
        int allProductCount,
        int soldOutProductCount,
        int reservedProductCount
) {
}
