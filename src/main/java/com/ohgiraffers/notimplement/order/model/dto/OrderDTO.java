package com.ohgiraffers.notimplement.order.model.dto;



import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDTO {
    private int orderSeq;
    private int orderNo;
    private String orderStatus;
    private LocalDateTime orderDate;
    private String userSeq;
}
