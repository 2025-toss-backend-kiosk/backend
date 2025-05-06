package com.study.jskkiosk.domain.menu.controller;

import com.study.jskkiosk.domain.menu.entity.dto.ResponseGetMenuAllDTO;
import com.study.jskkiosk.domain.menu.entity.dto.ResponseGetMenuDetailDTO;
import com.study.jskkiosk.domain.menu.entity.dto.ResponseGetMenuOptionDTO;
import com.study.jskkiosk.domain.menu.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/menus")
@Tag(name = "메뉴 API", description = "메뉴 조회 관련 API")
public class MenuController {

    private MenuService menuService;

    @Operation(summary = "상품 전체 조회", description = "category 전체 상품의 정보를 조회합니다.")
    @GetMapping("/{category}")
    public ResponseEntity<Map<String, Object>> getAllItem(@PathVariable("category") String category) {
        List<ResponseGetMenuAllDTO> items = menuService.getAll(category);
        boolean success = !items.isEmpty();

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "메뉴 리스트 조회 성공!" : "메뉴 리스트 조회 실패..");
        responseMap.put("itemList", items);

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

    @Operation(summary = "상품 디테일 조회", description = "itemID로 해당 상품의 정보를 조회합니다.")
    @GetMapping("/{menuItemId}")
    public ResponseEntity<Map<String, Object>> getItem(@RequestParam("menuItemId") UUID menuItemId) {
        ResponseGetMenuDetailDTO responseGetMenuDetailDTO = menuService.getDetail(menuItemId);

        boolean success = responseGetMenuDetailDTO != null;

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "메뉴 디테일 조회 성공!" : "메뉴 디테일 조회 실패..");
        responseMap.put("itemInfo", responseGetMenuDetailDTO);

        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

}
