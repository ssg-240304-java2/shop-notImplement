package com.ohgiraffers.notimplement.delivery.model.service;

import com.ohgiraffers.notimplement.delivery.model.dao.DeliveryMapper;
import com.ohgiraffers.notimplement.delivery.model.dto.DeliveryDTO;
import com.ohgiraffers.notimplement.delivery.paging.SelectDeliveryCriteria;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private static final Logger log = LoggerFactory.getLogger(DeliveryServiceImpl.class);
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

    @Override
    public void setOrderCompleted(int order) {
        log.info(order + " : " + deliveryMapper.checkDeliveryStatus(order));
        // delivery table에 있는 경우 -> delivery, order table UPDATE
        if (deliveryMapper.checkDeliveryStatus(order) > 0) {
            deliveryMapper.deleteDelivery(order);
            deliveryMapper.updateOrderStatus(order, "결제완료");
        } else {
            deliveryMapper.updateOrderStatus(order, "결제완료");
        }
    }
}
