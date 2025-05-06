package com.study.jskkiosk.domain.admin_ljy.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductDTO {
    private UUID categoryId;
    private String name;
    private int basePrice;
    private boolean isSoldOut;
}
