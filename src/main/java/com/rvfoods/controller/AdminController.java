package com.rvfoods.controller;

import com.rvfoods.model.*;
import com.rvfoods.repository.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final OrderMainRepository orderMainRepo;
    private final OrderItemRepository orderItemRepo;

    public AdminController(OrderMainRepository orderMainRepo, OrderItemRepository orderItemRepo) {
        this.orderMainRepo = orderMainRepo;
        this.orderItemRepo = orderItemRepo;
    }

    @GetMapping("/orders")
    public List<OrderMain> getOrders(@RequestParam(required = false) String status) {
        if (status == null) return orderMainRepo.findAll();
        return orderMainRepo.findByStatus(status);
    }

    @PutMapping("/order/{id}")
    public OrderMain updateStatus(@PathVariable Long id, @RequestParam String status) {
        Optional<OrderMain> o = orderMainRepo.findById(id);
        if (o.isPresent()) {
            OrderMain om = o.get();
            om.setStatus(status);
            return orderMainRepo.save(om);
        }
        return null;
    }
}
