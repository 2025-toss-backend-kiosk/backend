package com.study.jskkiosk.domain.order.controller;

import com.study.jskkiosk.domain.order.entity.OrderEntity;
import com.study.jskkiosk.domain.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    /** 주문 생성 (테스트용) */
    @PostMapping
    public ResponseEntity<UUID> create(@RequestBody CreateOrderDto dto) {
        OrderEntity order = OrderEntity.builder()
                .orderType(dto.orderType())
                .totalPrice(dto.totalPrice())
                .createdAt(LocalDateTime.now())
                .build();
        orderRepository.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order.getOrderId());
    }

    /** 주문 목록 */
    @GetMapping
    public ResponseEntity<List<OrderEntity>> list() {
        return ResponseEntity.ok(orderRepository.findAll());
    }
}

/* --- 간단 DTO --- */
record CreateOrderDto(String orderType, int totalPrice) {}
