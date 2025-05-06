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

@RestController
@RequestMapping("/api/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping
    public ResponseEntity<List<MenuListResponse>> getMenus() {
        return ResponseEntity.ok(menuService.getAllMenus());
    }
    @PostMapping
    @Operation(summary = "메뉴 등록")
    public ResponseEntity<ResponseGetMenuAllDTO> createMenu(@RequestBody MenuCreateRequest request) {
        ResponseGetMenuAllDTO created = menuService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

}
