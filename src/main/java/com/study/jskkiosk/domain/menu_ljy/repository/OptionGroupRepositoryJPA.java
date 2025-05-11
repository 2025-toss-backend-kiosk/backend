package com.study.jskkiosk.domain.menu_ljy.repository;

import com.study.jskkiosk.domain.menu_ljy.entity.OptionGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OptionGroupRepositoryJPA extends JpaRepository<OptionGroupEntity, String> {
    List<OptionGroupEntity> findAllByMenuItemId(String menuItemId);
}
