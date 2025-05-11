package com.study.jskkiosk.domain.points.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PointInfoResponseDTO {
    @Schema(description = "보유 적립금", example = "1200")
    private int points;
}
