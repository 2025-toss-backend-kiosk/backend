package com.study.jskkiosk.domain.order;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TakeoutOrNotService {

    private final TakeoutOrNotRepository takeoutOrNotRepository;

    @Transactional
    public UUID createOrder(ResponseCreateTakeoutOrNotDTO responseCreateTakeOUtOrNotDTO) {
        // 주문 타입 검증
        if (!responseCreateTakeOUtOrNotDTO.getOrderType().equals("DINEIN") && !responseCreateTakeOUtOrNotDTO.getOrderType().equals("TAKEOUT")) {
            throw new IllegalArgumentException("유효하지 않은 주문 타입입니다. 'DINEIN' 또는 'TAKEOUT'이어야 합니다.");
        }

        TakeoutOrNotEntity order = TakeoutOrNotEntity.builder()
                .orderId(UUID.randomUUID())
                .memberId(responseCreateTakeOUtOrNotDTO.getMemberId())
                .orderType(responseCreateTakeOUtOrNotDTO.getOrderType())
                .status("PENDING")
                .totalPrice(BigDecimal.ZERO) // 초기 금액 0으로 설정
                .createdAt(Timestamp.from(Instant.now()))
                .build();

        takeoutOrNotRepository.save(order);
        return order.getOrderId();
    }
}
