package com.study.jskkiosk.domain.admin_ljy.controller;

import com.study.jskkiosk.domain.admin_ljy.bean.ProductResponseDTO;
import com.study.jskkiosk.domain.admin_ljy.bean.CreateProductDTO;
import com.study.jskkiosk.domain.admin_ljy.bean.UpdateProductDTO;
import com.study.jskkiosk.domain.admin_ljy.bean.UpdateStockDTO;
import com.study.jskkiosk.domain.admin_ljy.service.ProductService;
import com.study.jskkiosk.global.dto.CommonResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/products")
@Tag(name = "관리자 API", description = "관리자용 상품/재고 관리 API")
public class AdminProductController {

    private final ProductService productService;

    @Operation(summary = "상품 목록 조회", description = "모든 상품 목록을 조회합니다.")
    @GetMapping
    public ResponseEntity<CommonResponseDTO<List<ProductResponseDTO>>> getAllProducts() {
        List<ProductResponseDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(
                CommonResponseDTO.<List<ProductResponseDTO>>builder()
                        .isSuccess(true)
                        .message("상품 목록 조회 성공!")
                        .data(products)
                        .build()
        );
    }

    @Operation(summary = "상품 추가", description = "새로운 상품을 추가합니다.")
    @PostMapping
    public ResponseEntity<CommonResponseDTO<UUID>> addProduct(@RequestBody CreateProductDTO productDTO) {
        UUID productId = productService.addProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                CommonResponseDTO.<UUID>builder()
                        .isSuccess(true)
                        .message("상품 추가 성공!")
                        .data(productId)
                        .build()
        );
    }

    @Operation(summary = "상품 수정", description = "상품 정보를 수정합니다.")
    @PatchMapping("/{productId}")
    public ResponseEntity<CommonResponseDTO<Void>> updateProduct(
            @PathVariable UUID productId,
            @RequestBody UpdateProductDTO productDTO) {
        productService.updateProduct(productId, productDTO);
        return ResponseEntity.ok(
                CommonResponseDTO.<Void>builder()
                        .isSuccess(true)
                        .message("상품 수정 성공!")
                        .data(null)
                        .build()
        );
    }

    @Operation(summary = "재고 수정/품절 변경", description = "상품의 재고 상태를 수정합니다.")
    @PatchMapping("/{productId}/stock")
    public ResponseEntity<CommonResponseDTO<Void>> updateStock(
            @PathVariable UUID productId,
            @RequestBody UpdateStockDTO stockDTO) {
        productService.updateStock(productId, stockDTO);
        return ResponseEntity.ok(
                CommonResponseDTO.<Void>builder()
                        .isSuccess(true)
                        .message("재고 상태 수정 성공!")
                        .data(null)
                        .build()
        );
    }
}
