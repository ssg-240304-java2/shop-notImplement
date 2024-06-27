package com.ohgiraffers.notimplement.order.controller;

import com.ohgiraffers.notimplement.auth.model.dto.UserDTO;
import com.ohgiraffers.notimplement.order.model.dto.DetailOrderDTO;
import com.ohgiraffers.notimplement.order.model.dto.OrderDTO;
import com.ohgiraffers.notimplement.order.model.dto.OrderDeliveryDTO;
import com.ohgiraffers.notimplement.order.model.dto.ProcessOrderDTO;
import com.ohgiraffers.notimplement.order.model.service.OrderService;
import com.ohgiraffers.notimplement.product.model.dto.ProductResponse;
import com.ohgiraffers.notimplement.product.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;

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

        List<OrderDeliveryDTO> orderDeliveryList = orderService.findAllOrderDelivery(userId);
        model.addAttribute("orderDeliveryList", orderDeliveryList);

        return "userPage/order/orderDeliveryLookup";
    }

    // 구매자 주문서 작성
    @GetMapping("/orderProcess")
    public String placeOrder(@RequestParam("productSequence") int productSequence,
                             @RequestParam("month") int month, Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("id");

        UserDTO user = orderService.getUserData(userId);

        model.addAttribute("productSequence", productSequence);
        model.addAttribute("user", user);

        // 1.find product
//        ProcessOrderDTO processOrderList = productService.findAllOrderProcess(productSequence);
//        if (processOrderList == null) {
//
//            return "userPage/product/main";
//        }


        ProductResponse productById = productService.getById(productSequence);

        model.addAttribute("productById", productById);


        // 2. update price
//        int updatedPrice = processOrderList.getProductPrice() * month;

        int newPrice = productById.price() * month;
        model.addAttribute("newPrice", newPrice);

        // 3. make order
        ProcessOrderDTO processOrderList = new ProcessOrderDTO();

        // 4. save order
//        List<ProcessOrderDTO> processOrderList =
        orderService.save(productSequence, newPrice);

//        model.addAttribute("processOrderList", processOrderList);

        return "userPage/order/processOrder";
    }

    @PostMapping("/sendOrder")
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @ResponseBody
    public String sendOrder(@RequestParam String productSeq, @RequestParam String productPrice, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("id");

        orderService.sendOrder(productSeq, productPrice, userId);

        return "주문에 성공하였습니다.";
    }
}
















