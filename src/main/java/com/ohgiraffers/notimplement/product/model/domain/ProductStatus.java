package com.ohgiraffers.notimplement.product.model.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ProductStatus {
    NEW(1, "신규 상품"),
    RESERVED(2,"예약 상품"),
    SOLD_OUT(3,"품절 상품")
    ;

    private final int code;
    private final String title;
}
