package com.study.jskkiosk.domain.points.entity.dto;

import lombok.Getter;

@Getter
public class PointRequestDTO {
    private int amount; // 차감할 포인트 금액 (프론트에서 입력)
}
