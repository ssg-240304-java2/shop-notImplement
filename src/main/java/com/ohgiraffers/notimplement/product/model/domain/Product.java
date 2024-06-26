package com.ohgiraffers.notimplement.product.model.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class Product {
    private int sequence;
    private int categoryCode;
    private String brand;
    private String name;
    private int price;
    private String description;
    private int amount;
    private ProductStatus status;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;

    public Product(int sequence, int categoryCode, String brand, String name, int price, String description, int amount) {
        this.sequence = sequence;
        this.categoryCode = categoryCode;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.description = description;
        this.amount = amount;
        this.status = ProductStatus.NEW;
        this.regDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }
}
