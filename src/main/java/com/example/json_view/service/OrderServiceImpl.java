package com.example.json_view.service;

import com.example.json_view.model.Order;
import com.example.json_view.model.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    OrderRepository orderRepository;
    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        if (getOrder(id)!=null){
            Order oldOrder = getOrder(id);
            oldOrder.setProduct(order.getProduct());
            oldOrder.setPrice(order.getPrice());
            oldOrder.setStatus(order.getStatus());
            return orderRepository.save(oldOrder);
        }else {
            return null;
        }
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
