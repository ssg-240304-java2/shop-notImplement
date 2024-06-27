package com.ohgiraffers.notimplement.product.model.domain;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ProductStatus {
    NEW("NEW", "신규 상품"),
    RESERVED("RESERVED","예약 상품"),
    SOLD_OUT("SOLD_OUT","품절 상품"),
    ;

    private final String code;
    private final String title;

    ProductStatus(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public static ProductStatus valueOfCode(String code) {
        return Arrays.stream(ProductStatus.values())
                .filter(it -> it.code.equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 코드를 찾을 수 없습니다." + code));
    }
}
