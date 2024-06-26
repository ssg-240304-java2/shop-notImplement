package com.ohgiraffers.notimplement.product.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product {
    private int productSeq;
    private int categoryCode;
    private String productBrand;
    private String productName;
    private int productPrice;
    private String productDescription;
    private int productAmount;
    private ProductStatus productStatus;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
}
