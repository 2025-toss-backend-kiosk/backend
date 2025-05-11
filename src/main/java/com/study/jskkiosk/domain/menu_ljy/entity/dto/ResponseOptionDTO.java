package com.study.jskkiosk.domain.menu_ljy.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseOptionDTO {
    private String optionId;
    private String name;
    private int addPrice;
}
