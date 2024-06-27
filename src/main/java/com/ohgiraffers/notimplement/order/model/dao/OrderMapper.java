package com.ohgiraffers.notimplement.order.model.dao;

import com.ohgiraffers.notimplement.order.model.dto.DetailOrderDTO;
import com.ohgiraffers.notimplement.order.model.dto.OrderDTO;
import com.ohgiraffers.notimplement.order.model.dto.OrderDeliveryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<OrderDTO> findAllOrder();

    List<DetailOrderDTO> findAllDetailInfo();

    List<OrderDeliveryDTO> findAllOrderDelivery(String userId);
}
