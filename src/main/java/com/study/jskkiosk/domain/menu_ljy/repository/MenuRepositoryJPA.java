package com.study.jskkiosk.domain.menu_ljy.repository;

import com.study.jskkiosk.domain.menu_ljy.entity.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MenuRepositoryJPA extends JpaRepository<MenuItemEntity, UUID> {
    List<MenuItemEntity> findAllByCategoryId(UUID categoryId);  // ✅ 하나만 선언

    Optional<MenuItemEntity> findById(UUID menuItemId);          // 이건 기본 구현이지만, 명시적으로 써도 OK
}

