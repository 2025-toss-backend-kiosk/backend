package com.study.jskkiosk.domain.points.repository;

import com.study.jskkiosk.domain.points.entity.PointHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PointHistoryRepositoryJPA extends JpaRepository<PointHistoryEntity, Long> {
    List<PointHistoryEntity> findByMemberIdOrderByCreatedAtDesc(Long memberId);
}
