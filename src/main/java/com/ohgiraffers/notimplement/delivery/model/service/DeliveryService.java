package com.ohgiraffers.notimplement.delivery.model.service;

import com.ohgiraffers.notimplement.delivery.model.dto.DeliveryDTO;
import com.ohgiraffers.notimplement.delivery.paging.SelectDeliveryCriteria;

import java.util.List;

public interface DeliveryService {
    List<DeliveryDTO> getAllDeliveryList(SelectDeliveryCriteria selectCriteria);

    int getTotalCount();

    void setOrderCompleted(int order);
}
