package com.study.jskkiosk.domain.order;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TakeoutOrNotRepository extends JpaRepository<TakeoutOrNotEntity, UUID> {
}
