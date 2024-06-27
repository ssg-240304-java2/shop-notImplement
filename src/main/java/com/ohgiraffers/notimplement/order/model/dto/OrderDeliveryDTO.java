package com.ohgiraffers.notimplement.order.model.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDeliveryDTO {

    private String userSeq;
    private String orderStatus;
    private LocalDateTime orderDate;
    private int orderNo;
    private int productSeq;
    private String productName;
    private String productDescription;
    private LocalDateTime regDate;

}
