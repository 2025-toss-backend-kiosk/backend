package com.study.jskkiosk.domain.menu.bean.small;

import com.study.jskkiosk.domain.menu.entity.MenuItemEntity;
import com.study.jskkiosk.domain.menu.repository.MenuRepositoryJPA;

import java.util.List;
import java.util.UUID;

public class GetMenuItemEntityBean {
    private final MenuRepositoryJPA menuRepositoryJPA;

    public GetMenuItemEntityBean(MenuRepositoryJPA menuRepositoryJPA) {
        this.menuRepositoryJPA = menuRepositoryJPA;
    }

    public List<MenuItemEntity> exec(String category) {
        return menuRepositoryJPA.findAllByCategory(category);
    }

    public List<MenuItemEntity> exec() {
        return menuRepositoryJPA.findAll();
    }

    public MenuItemEntity exec(UUID menuItemId) {
        return menuRepositoryJPA.findById(menuItemId).orElse(null);
    }
}
