package com.example.Evaluations.evaluation.services;



import com.example.Evaluations.evaluation.model.Order;

import java.util.UUID;

public interface IOrderService {
    Order createOrder(Long customerId, Double totalAmount);

    Boolean deleteOrder(UUID orderId);
}