package com.ohgiraffers.notimplement.order.model.dao;

import com.ohgiraffers.notimplement.auth.model.dto.UserDTO;
import com.ohgiraffers.notimplement.order.model.dto.DetailOrderDTO;
import com.ohgiraffers.notimplement.order.model.dto.OrderDTO;
import com.ohgiraffers.notimplement.order.model.dto.OrderDeliveryDTO;
import com.ohgiraffers.notimplement.order.model.dto.ProcessOrderDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<OrderDTO> findAllOrder();

    List<DetailOrderDTO> findAllDetailInfo();

    List<OrderDeliveryDTO> findAllOrderDelivery();

    List<ProcessOrderDTO> findAllOrderProcess();

    UserDTO getUserData(String userId);

    void sendOrder(String userId);

    void sendOrderProduct(String productSeq, String productPrice);

    void payOrder(String userId, String productPrice);

    void reduceStock(String productSeq);

//    void save(int productSequence, int newPrice);
}
