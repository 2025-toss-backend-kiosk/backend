package com.study.jskkiosk.domain.points.service;

import com.study.jskkiosk.domain.order.TakeoutOrNotEntity;
import com.study.jskkiosk.domain.order.TakeoutOrNotRepository;
import com.study.jskkiosk.domain.points.entity.MemberEntity;
import com.study.jskkiosk.domain.points.entity.PointHistoryEntity;
import com.study.jskkiosk.domain.points.repository.PointHistoryRepositoryJPA;
import com.study.jskkiosk.domain.points.repository.PointRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointRepositoryJPA pointRepository;
    private final TakeoutOrNotRepository takeoutOrNotRepository;
    private final PointHistoryRepositoryJPA historyRepository;

    public int getPoints(Long memberId) {
        MemberEntity member = pointRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        return member.getPoint();
    }

    @Transactional
    public boolean addPointsByOrder(UUID orderId) {
        TakeoutOrNotEntity order = takeoutOrNotRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 주문입니다."));

        Long memberId = order.getMemberId();
        if (memberId == null) return false;

        MemberEntity member = pointRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        int earnedPoint = order.getTotalPrice().multiply(BigDecimal.valueOf(0.1)).intValue();
        member.addPoints(earnedPoint);

        historyRepository.save(PointHistoryEntity.create(memberId, earnedPoint, "SAVE"));
        return true;
    }

    @Transactional
    public boolean usePoints(Long memberId, int amount) {
        MemberEntity member = pointRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        if (member.getPoint() < amount) return false;

        member.usePoints(amount);
        historyRepository.save(PointHistoryEntity.create(memberId, -amount, "USE"));
        return true;
    }

    public List<PointHistoryEntity> getLogs(Long memberId) {
        return historyRepository.findByMemberIdOrderByCreatedAtDesc(memberId);
    }
}
