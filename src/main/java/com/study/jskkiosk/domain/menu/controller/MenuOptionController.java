package com.study.jskkiosk.domain.menu.controller;

import com.study.jskkiosk.domain.menu.entity.dto.ResponseOptionGroupDTO;
import com.study.jskkiosk.domain.menu.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/menus")
public class MenuOptionController {

    private final OptionService optionService;

    @GetMapping("/{menuId}/options")
    public ResponseEntity<List<ResponseOptionGroupDTO>> getMenuOptions(@PathVariable UUID menuId) {
        return ResponseEntity.ok(optionService.getOptionsByMenuId(menuId));
    }
}
