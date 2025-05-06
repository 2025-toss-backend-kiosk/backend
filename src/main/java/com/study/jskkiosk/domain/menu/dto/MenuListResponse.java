package com.study.jskkiosk.domain.menu.dto;

import com.study.jskkiosk.domain.menu.entity.MenuItemEntity;

import java.util.UUID;

public record MenuListResponse(
        UUID menuItemId,
        String name,
        int basePrice
) {
    public static MenuListResponse from(MenuItemEntity m) {
        return new MenuListResponse(
                m.getMenuItemId(),
                m.getName(),
                m.getBasePrice()
        );
    }
}
