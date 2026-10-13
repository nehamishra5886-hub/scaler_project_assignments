package com.example.Evaluations.evaluation.services;


import com.example.Evaluations.evaluation.model.Order;
import com.example.Evaluations.evaluation.model.OrderStatus;
import com.example.Evaluations.evaluation.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Long customerId, Double totalAmount) {
        //Add your implementation here
        Order order = new Order();

        order.setId(UUID.randomUUID());
        order.setCustomerId(customerId);
        order.setTotalAmount(totalAmount);
        order.setStatus(OrderStatus.CREATED);

        Date currentDate = new Date();
        order.setCreatedAt(currentDate);
        order.setLastUpdatedAt(currentDate);

        orderRepository.save(order);

        return order;
    }

    @Override
    public Boolean deleteOrder(UUID orderId) {
        //Add your implementation here and return result rather than returning false
        return orderRepository.remove(orderId);
    }
}