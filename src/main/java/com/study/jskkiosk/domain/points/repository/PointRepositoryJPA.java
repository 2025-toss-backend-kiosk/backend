package com.study.jskkiosk.domain.points.repository;

import com.study.jskkiosk.domain.points.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepositoryJPA extends JpaRepository<MemberEntity, Long> {
}
