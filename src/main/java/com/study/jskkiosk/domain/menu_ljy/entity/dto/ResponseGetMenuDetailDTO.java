package com.study.jskkiosk.domain.menu_ljy.entity.dto;

import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseGetMenuDetailDTO {
    @Id
    UUID menuItemId;
    UUID categoryId;
    String name;
    int basePrice;
    boolean isSoldOut;
}
