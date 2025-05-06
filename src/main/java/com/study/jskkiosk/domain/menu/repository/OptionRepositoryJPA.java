package com.study.jskkiosk.domain.menu.repository;

import com.study.jskkiosk.domain.menu.entity.OptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OptionRepositoryJPA extends JpaRepository<OptionEntity, UUID> {
    List<OptionEntity> findAllByGroupId(UUID groupId);
}

