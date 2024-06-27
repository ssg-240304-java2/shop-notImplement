package com.ohgiraffers.notimplement.delivery.controller;

import com.ohgiraffers.notimplement.delivery.model.dto.DeliveryDTO;
import com.ohgiraffers.notimplement.delivery.model.service.DeliveryService;
import com.ohgiraffers.notimplement.delivery.paging.DeliveryPagenation;
import com.ohgiraffers.notimplement.delivery.paging.SelectDeliveryCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
@Slf4j
public class DeliveryController {
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/delivery")
    public String deliveryManager(Model model, @RequestParam(value = "currentPage", defaultValue = "1") int pageNo) {

        int totalDeliveryCount = deliveryService.getTotalCount();

        // 한 페이지에 보여줄 게시물 수
        int limit = 10;

        // 한번에 보여질 페이징 버튼의 개수
        int buttonAmount = 5;


        SelectDeliveryCriteria selectCriteria = DeliveryPagenation.getSelectCriteria(pageNo, totalDeliveryCount, limit, buttonAmount);

        List<DeliveryDTO> deliveryList = deliveryService.getAllDeliveryList(selectCriteria);

        log.info(">>>>>>" + selectCriteria.getPageNo());
        log.info(">>>>>>" + selectCriteria.getMaxPage());


        model.addAttribute("deliveryList", deliveryList);
        model.addAttribute("selectCriteria", selectCriteria);

        return "adminPage/delivery/deliveryManagement";
    }

    @PostMapping("/delivery/orderCompleted")
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @ResponseBody
    public String deliveryOrderCompleted(@RequestParam(value = "orderNumList[]") int[] orderList) {

        for (int order : orderList) {
            deliveryService.setOrderCompleted(order);
        }

        return " 주문 상태 변경 성공";
    }

    @PostMapping("/delivery/inDelivery")
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @ResponseBody
    public String inDelivery(@RequestParam(value = "orderNumList[]") int[] orderList) {

        for (int order : orderList) {
            deliveryService.setInDelivery(order);
        }

        return " 주문 상태 변경 성공";
    }

    @PostMapping("/delivery/completeDelivery")
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @ResponseBody
    public String completeDelivery(@RequestParam(value = "orderNumList[]") int[] orderList) {

        for (int order : orderList) {
            deliveryService.completeDelivery(order);
        }

        return " 주문 상태 변경 성공";
    }
}
