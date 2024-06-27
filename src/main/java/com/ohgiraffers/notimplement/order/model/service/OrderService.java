package com.ohgiraffers.notimplement.order.model.service;

import com.ohgiraffers.notimplement.auth.model.dto.UserDTO;
import com.ohgiraffers.notimplement.order.model.dto.DetailOrderDTO;
import com.ohgiraffers.notimplement.order.model.dto.OrderDTO;
import com.ohgiraffers.notimplement.order.model.dto.OrderDeliveryDTO;
import com.ohgiraffers.notimplement.order.model.dto.ProcessOrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> findAllOrder();

    List<DetailOrderDTO> findAllDetailInfo();

    List<OrderDeliveryDTO> findAllOrderDelivery(String userId);

    List<ProcessOrderDTO> findAllOrderProcess();

    void save(int productSequence, int newPrice);

    UserDTO getUserData(String userId);

    void sendOrder(String productSeq, String productPrice, String userId);
}
