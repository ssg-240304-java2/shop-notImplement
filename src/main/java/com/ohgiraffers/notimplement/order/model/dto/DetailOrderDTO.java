package com.ohgiraffers.notimplement.order.model.dto;

import lombok.*;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DetailOrderDTO {

    // 유저정보
    private int userSeq;
    private String userName;
    private String userEmail;
    private String userRrn;
    private String userPhone;
    private String userAddr;

    // 상품정보
    private String productName;
    private int productSeq;

    // 결제정보
    private LocalDateTime orderDate;




}
