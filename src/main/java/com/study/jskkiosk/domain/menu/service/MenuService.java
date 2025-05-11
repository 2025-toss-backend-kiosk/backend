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

    /** 전체 메뉴 목록 */
    public List<MenuListResponse> getAllMenus() {
        return menuRepository.findAll()
                .stream()
                .map(MenuListResponse::from)
                .toList();
    }

    /** 단일 메뉴 상세 조회 (추가된 메서드) */
    public MenuListResponse getMenuById(UUID id) {
        MenuItemEntity entity = menuRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 메뉴가 존재하지 않습니다."));
        return MenuListResponse.from(entity);
    }

    /** 메뉴 등록 */
    public ResponseGetMenuAllDTO create(MenuCreateRequest request) {
        MenuItemEntity menu = MenuItemEntity.builder()
                .menuItemId(UUID.randomUUID())
                .name(request.name())
                .basePrice(request.basePrice())
                .category(request.category())
                .build();

        MenuItemEntity saved = menuRepository.save(menu);

        return ResponseGetMenuAllDTO.builder()
                .menuItemId(saved.getMenuItemId())
                .name(saved.getName())
                .basePrice(saved.getBasePrice())
                .category(saved.getCategory())
                .build();
    }
}
