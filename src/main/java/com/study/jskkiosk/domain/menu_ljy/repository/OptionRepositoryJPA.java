package com.study.jskkiosk.domain.menu_ljy.repository;

import com.study.jskkiosk.domain.menu_ljy.entity.OptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OptionRepositoryJPA extends JpaRepository<OptionEntity, String> {
    List<OptionEntity> findAllByGroupId(String groupId);
}

