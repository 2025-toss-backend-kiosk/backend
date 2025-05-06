package com.study.jskkiosk.domain.menu.entity.dto;

import jakarta.persistence.Id;
import lombok.Builder;

import java.util.UUID;

@Builder
public class ResponseGetMenuDetailDTO {
    @Id
    UUID menuItemId;
    UUID categoryId;
    String name;
    int basePrice;
    boolean isSoldOut;
}
