package com.study.jskkiosk.domain.admin_ljy.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateProductDTO {
    private String name;
    private Integer basePrice;
}
