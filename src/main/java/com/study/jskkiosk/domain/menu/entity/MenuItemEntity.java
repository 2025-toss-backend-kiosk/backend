package com.study.jskkiosk.domain.menu.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MenuItemEntity {
    @Id
    UUID menuItemId;
    UUID categoryId;
    String name;
    int basePrice;
    boolean isSoldOut;
}
