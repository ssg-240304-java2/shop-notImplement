package com.ohgiraffers.notimplement.delivery.model.dao;

import com.ohgiraffers.notimplement.delivery.model.dto.DeliveryDTO;
import com.ohgiraffers.notimplement.delivery.paging.SelectDeliveryCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeliveryMapper {
    List<DeliveryDTO> getAllDeliveryList(SelectDeliveryCriteria selectCriteria);

    int getTotalCount();

    String checkDeliveryStatus(int order);
    
    void deleteDelivery(int order);

    void startDelivery(int order);

    void revertDeliveryComplete(int order);
}
