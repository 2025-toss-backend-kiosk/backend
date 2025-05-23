package com.study.jskkiosk.domain.order.repository;

import com.study.jskkiosk.domain.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {}
