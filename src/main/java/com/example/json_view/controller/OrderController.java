package com.example.json_view.controller;

import com.example.json_view.model.Order;
import com.example.json_view.service.OrderService;
import com.example.json_view.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;
    @GetMapping("/{id}")
    @JsonView(Views.UserDetails.class)
    public Order getOrder(@PathVariable Long id){
        return orderService.getOrder(id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order){
       return orderService.createOrder(order);
    }

    @PatchMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order){
        return orderService.updateOrder(id,order);
    }

}
