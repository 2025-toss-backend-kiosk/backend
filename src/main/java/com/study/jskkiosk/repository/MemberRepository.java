package com.study.jskkiosk.repository;

import com.study.jskkiosk.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}