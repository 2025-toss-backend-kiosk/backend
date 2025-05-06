package com.study.jskkiosk.domain.menu.service;

import com.study.jskkiosk.domain.menu.dto.MenuCreateRequest;
import com.study.jskkiosk.domain.menu.dto.MenuListResponse;
import com.study.jskkiosk.domain.menu.dto.ResponseGetMenuAllDTO;
import com.study.jskkiosk.domain.menu.entity.MenuItemEntity;
import com.study.jskkiosk.domain.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public List<MenuListResponse> getAllMenus() {
        return menuRepository.findAll().stream()
                .map(MenuListResponse::from)
                .toList();
    }

    public ResponseGetMenuAllDTO create(MenuCreateRequest request) {
        MenuItemEntity menu = MenuItemEntity.builder()
                .menuItemId(UUID.randomUUID())
                .name(request.name())
                .basePrice(request.basePrice())
                .build();

        MenuItemEntity saved = menuRepository.save(menu);

        return ResponseGetMenuAllDTO.builder()
                .menuItemId(saved.getMenuItemId())
                .name(saved.getName())
                .basePrice(saved.getBasePrice())
                .build();
    }
}
