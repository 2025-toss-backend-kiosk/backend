package com.study.jskkiosk.domain.order;

import jakarta.persistence.*;
        import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class TakeoutOrNotEntity {
    @Id
    @Column(name = "order_id")
    private UUID orderId;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "order_type", nullable = false)
    private String orderType;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;
}
