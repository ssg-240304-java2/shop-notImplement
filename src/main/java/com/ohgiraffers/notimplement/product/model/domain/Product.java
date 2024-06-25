package com.ohgiraffers.notimplement.product.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Product {
    private int product_seq;
    private int category_code;
    private String product_brand;
    private String product_name;
    private int product_price;
    private String product_description;
    private int product_amount;
    private ProductStatus product_status;
    private LocalDateTime reg_date;
    private LocalDateTime update_date;

}
