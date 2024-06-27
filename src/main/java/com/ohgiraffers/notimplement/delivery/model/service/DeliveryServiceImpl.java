package com.ohgiraffers.notimplement.delivery.model.service;

import com.ohgiraffers.notimplement.delivery.model.dao.DeliveryMapper;
import com.ohgiraffers.notimplement.delivery.model.dto.DeliveryDTO;
import com.ohgiraffers.notimplement.delivery.paging.SelectDeliveryCriteria;
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
        // delivery table에 있는 경우 -> delivery table UPDATE
        if (deliveryMapper.checkDeliveryStatus(order) != null) {
            deliveryMapper.deleteDelivery(order);
        }
    }

    @Override
    public void setInDelivery(int order) {
        // 배송중이면 변경하면 안됨
        // 배송 완료면 배송완료 시간을 제거
        // 결제완료면 배송시간과 상태를 변경 -> delivery,order 다 변경
        log.info("배송 테이블 상태 조회 >>>>>>>>>> " + deliveryMapper.checkDeliveryStatus(order));

        String status = deliveryMapper.checkDeliveryStatus(order);
        if (status == null) { // 결제 완료
            deliveryMapper.startDelivery(order);
        } else if (status.equals("배송완료")) { // 배송 완료 상태
            deliveryMapper.revertDeliveryComplete(order);
        }
    }

    @Override
    public void completeDelivery(int order) {
        String status = deliveryMapper.checkDeliveryStatus(order);
        if (status == null) { // 결제 완료
            deliveryMapper.startDelivery(order);
            deliveryMapper.completeDelivery(order);
        } else if (status.equals("배송중")) { // 배송중
            deliveryMapper.completeDelivery(order);
        }

    }
}
