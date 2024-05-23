package com.example.json_view.service;

import com.example.json_view.model.Order;

public interface OrderService {
    Order createOrder(Order order);
    Order getOrder(Long id);
    Order updateOrder(Long id, Order order);
    void deleteOrder(Long id);
}
