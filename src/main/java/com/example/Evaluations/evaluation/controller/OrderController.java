package com.example.Evaluations.evaluation.controller;

import com.example.Evaluations.evaluation.dtos.OrderRequestDto;
import com.example.Evaluations.evaluation.model.Order;
import com.example.Evaluations.evaluation.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    //Please add APIs here
    @PostMapping
    public Order createOrder(@RequestBody OrderRequestDto requestDto) {
        return orderService.createOrder(
                requestDto.getCustomerId(),
                requestDto.getTotalAmount()
        );
    }
    @DeleteMapping("/{orderId}")
    public Boolean deleteOrder(@PathVariable UUID orderId) {
        return orderService.deleteOrder(orderId);
    }

}