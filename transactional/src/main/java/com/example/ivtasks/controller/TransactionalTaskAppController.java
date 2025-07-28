package com.example.ivtasks.controller;

import com.example.ivtasks.transactional.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TransactionalTaskAppController {

    private final OrderService orderService;

    public TransactionalTaskAppController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/transactions")
    public void testOrders() {
        try {
            orderService.save();
        } finally {
            orderService.printDbStatus();
        }
    }

}
