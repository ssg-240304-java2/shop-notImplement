package com.ohgiraffers.notimplement.order.controller;

import com.ohgiraffers.notimplement.order.model.dto.DetailOrderDTO;
import com.ohgiraffers.notimplement.order.model.dto.OrderDTO;
import com.ohgiraffers.notimplement.order.model.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/infoLookup")
    public String findOrderList(Model model) {
        List<OrderDTO> orderList = orderService.findAllOrder();
        model.addAttribute("orderList", orderList);

        return "adminPage/order/orderInfoLookup";
    }



    @GetMapping("/detailInfo")
    public String detailOrder(Model model) {

        List<DetailOrderDTO> detailOrderList = orderService.findAllDetailInfo();
        model.addAttribute("detailOrderList", detailOrderList);


        return "adminPage/order/orderDetailsInfo";
    }
}














