package com.study.jskkiosk.domain.menu.controller;

import com.study.jskkiosk.domain.menu.dto.MenuCreateRequest;
import com.study.jskkiosk.domain.menu.dto.MenuListResponse;
import com.study.jskkiosk.domain.menu.dto.ResponseGetMenuAllDTO;
import com.study.jskkiosk.domain.menu.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * 메뉴(상품) 관련 API 컨트롤러
 */
@RestController
@RequestMapping("/api/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    /** 전체 메뉴 조회 */
    @GetMapping
    public ResponseEntity<List<MenuListResponse>> getMenus() {
        return ResponseEntity.ok(menuService.getAllMenus());
    }

    /** 단일 메뉴 상세 조회 */
    @GetMapping("/{menuItemId}")
    @Operation(summary = "메뉴 상세 조회")
    public ResponseEntity<MenuListResponse> getMenuById(@PathVariable UUID menuItemId) {
        return ResponseEntity.ok(menuService.getMenuById(menuItemId));
    }

    /** 메뉴 등록 */
    @PostMapping
    @Operation(summary = "메뉴 등록")
    public ResponseEntity<ResponseGetMenuAllDTO> createMenu(@RequestBody MenuCreateRequest request) {
        ResponseGetMenuAllDTO created = menuService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
