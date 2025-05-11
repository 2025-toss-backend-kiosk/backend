package com.study.jskkiosk.repository;

import com.study.jskkiosk.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByPhone(String phone); // ← 반드시 인터페이스 안에 위치해야 함

}
