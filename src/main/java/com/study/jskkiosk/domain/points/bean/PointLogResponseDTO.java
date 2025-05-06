package com.study.jskkiosk.domain.points.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PointLogResponseDTO {
    @Schema(description = "적립/차감 금액", example = "300")
    private int amount;

    @Schema(description = "적립/차감 타입", example = "SAVE / USE")
    private String type;

    @Schema(description = "내역 생성 시각", example = "2025-05-06T10:12:00")
    private LocalDateTime createdAt;
}
