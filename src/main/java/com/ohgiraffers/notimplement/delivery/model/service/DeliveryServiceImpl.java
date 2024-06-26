package com.ohgiraffers.notimplement.delivery.model.service;

import com.ohgiraffers.notimplement.delivery.model.dao.DeliveryMapper;
import com.ohgiraffers.notimplement.delivery.model.dto.DeliveryDTO;
import com.ohgiraffers.notimplement.delivery.paging.SelectDeliveryCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryMapper deliveryMapper;

    public DeliveryServiceImpl(DeliveryMapper deliveryMapper) {
        this.deliveryMapper = deliveryMapper;
    }

    @Override
    public List<DeliveryDTO> getAllDeliveryList(SelectDeliveryCriteria selectCriteria) {
        return deliveryMapper.getAllDeliveryList(selectCriteria);
    }

    @Override
    public int getTotalCount() {
        return deliveryMapper.getTotalCount();
    }
}
