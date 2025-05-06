package com.study.jskkiosk.domain.admin_ljy.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
    @Schema(description = "상품 ID", example = "550e8400-e29b-41d4-a716-446655440000")
    private UUID productId;

    @Schema(description = "카테고리 ID", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID categoryId;

    @Schema(description = "상품명", example = "아메리카노")
    private String name;

    @Schema(description = "기본 가격", example = "3000")
    private int basePrice;

    @Schema(description = "품절 여부", example = "false")
    private boolean isSoldOut;
}
