package com.study.jskkiosk.domain.admin_ljy.service;

import com.study.jskkiosk.domain.admin_ljy.bean.CreateProductDTO;
import com.study.jskkiosk.domain.admin_ljy.bean.ProductResponseDTO;
import com.study.jskkiosk.domain.admin_ljy.bean.UpdateProductDTO;
import com.study.jskkiosk.domain.admin_ljy.bean.UpdateStockDTO;
import com.study.jskkiosk.domain.menu_ljy.entity.MenuItemEntity;
import com.study.jskkiosk.domain.menu_ljy.repository.MenuRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final MenuRepositoryJPA menuRepository;

    public List<ProductResponseDTO> getAllProducts() {
        return menuRepository.findAll().stream()
                .map(menuItem -> ProductResponseDTO.builder()
                        .productId(menuItem.getMenuItemId())
                        .categoryId(menuItem.getCategoryId())
                        .name(menuItem.getName())
                        .basePrice(menuItem.getBasePrice())
                        .isSoldOut(menuItem.isSoldOut())
                        .build())
                .collect(Collectors.toList());
    }

    @Transactional
    public UUID addProduct(CreateProductDTO dto) {
        UUID productId = UUID.randomUUID();
        MenuItemEntity entity = MenuItemEntity.builder()
                .menuItemId(productId)
                .categoryId(dto.getCategoryId())
                .name(dto.getName())
                .basePrice(dto.getBasePrice())
                .isSoldOut(dto.isSoldOut())
                .build();
        menuRepository.save(entity);
        return productId;
    }

    @Transactional
    public void updateProduct(UUID productId, UpdateProductDTO dto) {
        MenuItemEntity item = menuRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));

        item.updateProduct(dto.getName(), dto.getBasePrice());
    }

    @Transactional
    public void updateStock(UUID productId, UpdateStockDTO dto) {
        MenuItemEntity item = menuRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));

        item.updateStock(dto.isSoldOut());
    }
}