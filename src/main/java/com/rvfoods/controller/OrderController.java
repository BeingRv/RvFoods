package com.rvfoods.controller;

import com.rvfoods.dto.OrderRequest;
import com.rvfoods.model.*;
import com.rvfoods.repository.*;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;
import org.springframework.http.*;

@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderMainRepository orderMainRepo;
    private final OrderItemRepository orderItemRepo;

    public OrderController(OrderMainRepository orderMainRepo, OrderItemRepository orderItemRepo) {
        this.orderMainRepo = orderMainRepo;
        this.orderItemRepo = orderItemRepo;
    }

    @PostMapping("/order")
    public ResponseEntity<Map<String, Object>> placeOrder(@RequestBody OrderRequest req) {
        OrderMain om = new OrderMain();
        om.setTableId(req.getTableId());
        om.setStatus("PENDING");
        om.setCreatedAt(LocalDateTime.now());
        om = orderMainRepo.save(om);

        for (OrderRequest.OrderLine line : req.getItems()) {
            OrderItem oi = new OrderItem();
            oi.setOrderId(om.getId());
            oi.setItemId(line.getItemId());
            oi.setQuantity(line.getQuantity());
            oi.setStatus("PENDING");
            orderItemRepo.save(oi);
        }
        Map<String, Object> res = Map.of("orderId", om.getId(), "status", om.getStatus());
        return ResponseEntity.ok(res);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<?> getOrder(@PathVariable Long id) {
        Optional<OrderMain> o = orderMainRepo.findById(id);
        if (o.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "not found"));
        List<OrderItem> items = orderItemRepo.findByOrderId(id);
        Map<String, Object> res = new HashMap<>();
        res.put("order", o.get());
        res.put("items", items);
        return ResponseEntity.ok(res);
    }
}
