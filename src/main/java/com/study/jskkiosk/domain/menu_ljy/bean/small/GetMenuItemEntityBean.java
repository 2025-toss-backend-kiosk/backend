package com.study.jskkiosk.domain.menu_ljy.bean.small;

import com.study.jskkiosk.domain.menu_ljy.entity.MenuItemEntity;
import com.study.jskkiosk.domain.menu_ljy.repository.MenuRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetMenuItemEntityBean {
    private final MenuRepositoryJPA menuRepositoryJPA;

    public GetMenuItemEntityBean(MenuRepositoryJPA menuRepositoryJPA) {
        this.menuRepositoryJPA = menuRepositoryJPA;
    }

    public List<MenuItemEntity> execByCategoryId(UUID categoryId) {
        return menuRepositoryJPA.findAllByCategoryId(categoryId);
    }


    public List<MenuItemEntity> execByMenuItemId() {
        return menuRepositoryJPA.findAll();
    }

    public MenuItemEntity exec(UUID menuItemId) {
        return menuRepositoryJPA.findById(menuItemId).orElse(null);
    }
}
