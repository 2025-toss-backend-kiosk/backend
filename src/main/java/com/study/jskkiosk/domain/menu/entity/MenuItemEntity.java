package com.study.jskkiosk.domain.menu.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "menu_item")
public class MenuItemEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "menu_item_id", columnDefinition = "BINARY(16)")
    private UUID menuItemId;

    @Column(nullable = false)
    private String name;

    @Column(name = "base_price", nullable = false)
    private int basePrice;

    @Column(nullable = false)
    private String category;
}