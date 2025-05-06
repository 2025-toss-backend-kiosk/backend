package com.study.jskkiosk.domain.menu.entity;

import jakarta.persistence.Column;
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
    @Column(name = "menu_item_id")
    private UUID menuItemId;

    @Column(name = "category_id")
    private UUID categoryId;

    @Column(name = "name")
    private String name;

    @Column(name = "base_price")
    private int basePrice;

    @Column(name = "is_sold_out")
    private boolean isSoldOut;

    // ✅ 상품 정보 수정 메서드
    public void updateProduct(String name, Integer basePrice) {
        if (name != null) this.name = name;
        if (basePrice != null) this.basePrice = basePrice;
    }

    // ✅ 재고 품절 상태 수정 메서드
    public void updateStock(boolean isSoldOut) {
        this.isSoldOut = isSoldOut;
    }
}
