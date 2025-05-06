package com.study.jskkiosk.domain.menu.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ResponseGetMenuAllDTO(
        UUID menuItemId,
        String name,
        int basePrice,
        boolean isSoldOut
) {}
