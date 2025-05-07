package com.study.jskkiosk.domain.order.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "order_id", columnDefinition = "BINARY(16)")
    private UUID orderId;

    @Column(name = "order_type", nullable = false, length = 10)
    private String orderType;        // "DINEIN" | "TAKEOUT"

    @Column(nullable = false)
    private int totalPrice;          // 상품 금액 합계

    @Column(nullable = false)
    private LocalDateTime createdAt; // 주문 시각
}
