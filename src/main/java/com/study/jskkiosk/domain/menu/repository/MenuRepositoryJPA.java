package com.study.jskkiosk.domain.menu.repository;

import com.study.jskkiosk.domain.menu.entity.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MenuRepositoryJPA extends JpaRepository<MenuItemEntity, UUID> {
    List<MenuItemEntity> findAllByCategory(String category);

    Optional<MenuItemEntity> findById(UUID menuItemId);


    //List<MenuItemEntity> findAll();
}
