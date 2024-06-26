package com.ohgiraffers.notimplement.order.model.service;

import com.ohgiraffers.notimplement.order.model.dao.OrderMapper;
import com.ohgiraffers.notimplement.order.model.dto.DetailOrderDTO;
import com.ohgiraffers.notimplement.order.model.dto.OrderDTO;
import com.ohgiraffers.notimplement.order.model.dto.OrderDeliveryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDTO> findAllOrder() {
        return orderMapper.findAllOrder();
    }


    @Override
    public List<DetailOrderDTO> findAllDetailInfo() {
        return orderMapper.findAllDetailInfo();
    }

    @Override
    public List<OrderDeliveryDTO> findAllOrderDelivery(String userId) {
        return orderMapper.findAllOrderDelivery();
    }
}