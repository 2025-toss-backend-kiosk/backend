package com.study.jskkiosk.domain.order;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
@Tag(name = "주문 API", description = "주문 관련 API")
public class TakeoutOrNotController {

    private final TakeoutOrNotService takeoutOrNotService;

    @Operation(summary = "매장/포장 선택", description = "주문 유형을 매장 또는 포장으로 선택합니다.")
    @PostMapping
    public ResponseEntity<Map<String, Object>> createOrder(@RequestBody ResponseCreateTakeoutOrNotDTO responseCreateTakeoutOrNotDTO) {
        UUID orderId = takeoutOrNotService.createOrder(responseCreateTakeoutOrNotDTO);
        boolean success = orderId != null;

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("isSuccess", success);
        responseMap.put("message", success ? "주문 생성 성공!" : "주문 생성 실패..");
        responseMap.put("orderId", orderId);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
    }
}