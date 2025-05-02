package com.study.jskkiosk.domain.menu.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseOptionDTO {
    private UUID optionId;
    private String name;
    private int addPrice;
}
