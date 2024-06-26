package com.ohgiraffers.notimplement.order.model.service;

import com.ohgiraffers.notimplement.order.model.dto.DetailOrderDTO;
import com.ohgiraffers.notimplement.order.model.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> findAllOrder();

    List<DetailOrderDTO> findAllDetailInfo();
}
