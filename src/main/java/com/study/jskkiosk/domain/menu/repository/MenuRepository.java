package com.study.jskkiosk.domain.menu.repository;

import com.study.jskkiosk.domain.menu.entity.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MenuRepository extends JpaRepository<MenuItemEntity, UUID> {
}
