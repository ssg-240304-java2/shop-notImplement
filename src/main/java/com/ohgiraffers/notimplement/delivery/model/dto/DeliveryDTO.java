package com.ohgiraffers.notimplement.delivery.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DeliveryDTO {
    private int orderSeq;
    private String orderStatus;
    private String orderDate;
    private int userSeq;
    private String userName;
    private String deliveryStatus;
    private String orderItemName;
    private int orderPrice;
}
