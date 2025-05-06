package com.study.jskkiosk.auth.phone.repository;

import com.study.jskkiosk.auth.phone.domain.PhoneAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhoneAuthRepository extends JpaRepository<PhoneAuth, Long> {
    Optional<PhoneAuth> findByPhone(String phone);
}
