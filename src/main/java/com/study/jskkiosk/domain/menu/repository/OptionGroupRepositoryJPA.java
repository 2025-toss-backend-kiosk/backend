package com.study.jskkiosk.domain.menu.repository;

import com.study.jskkiosk.domain.menu.entity.OptionGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OptionGroupRepositoryJPA extends JpaRepository<OptionGroupEntity, UUID> {
    List<OptionGroupEntity> findAllByMenuItemId(UUID menuItemId);
}
