package com.study.jskkiosk.domain.menu.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "menu_item")
public class MenuItemEntity {

    @Id
    @Column(name = "menu_item_id", columnDefinition = "BINARY(16)")
    private UUID menuItemId;

    @Column(nullable = false)
    private String name;

    @Column(name = "base_price", nullable = false)
    private int basePrice;
}
