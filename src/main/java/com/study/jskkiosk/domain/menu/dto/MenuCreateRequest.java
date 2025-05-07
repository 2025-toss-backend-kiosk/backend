package com.study.jskkiosk.domain.menu.dto;

public record MenuCreateRequest(
        String name,
        int basePrice,
        String category
) {}
