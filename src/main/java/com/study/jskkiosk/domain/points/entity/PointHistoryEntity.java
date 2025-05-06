package com.study.jskkiosk.domain.points.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "point_history")
public class PointHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long memberId;

    private int amount;

    private String type;

    private LocalDateTime createdAt;

    public static PointHistoryEntity create(Long memberId, int amount, String type) {
        return PointHistoryEntity.builder()
                .memberId(memberId)
                .amount(amount)
                .type(type)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
