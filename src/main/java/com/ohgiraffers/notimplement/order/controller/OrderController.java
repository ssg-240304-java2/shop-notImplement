package com.ohgiraffers.notimplement.order.controller;

import com.ohgiraffers.notimplement.order.model.dto.DetailOrderDTO;
import com.ohgiraffers.notimplement.order.model.dto.OrderDTO;
import com.ohgiraffers.notimplement.order.model.dto.OrderDeliveryDTO;
import com.ohgiraffers.notimplement.order.model.service.OrderService;
import com.ohgiraffers.notimplement.user.controller.UserController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    private final UserController user;

    public OrderController(OrderService orderService, UserController user) {
        this.orderService = orderService;
        this.user = user;
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

    // 구매자 주문배송조회
    @GetMapping("/orderDelivery")
    public String orderDelivery(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("id");

        System.out.println("userId = " + userId);
        List<OrderDeliveryDTO> orderDeliveryList = orderService.findAllOrderDelivery(userId);
        model.addAttribute("orderDeliveryList", orderDeliveryList);


        return "userPage/order/orderDeliveryLookup";
    }
}
