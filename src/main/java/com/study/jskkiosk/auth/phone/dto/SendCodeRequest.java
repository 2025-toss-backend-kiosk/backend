package com.study.jskkiosk.auth.phone.dto;

import jakarta.validation.constraints.Pattern;

/** 휴대폰 인증번호 전송 요청 */
public record SendCodeRequest(
        @Pattern(regexp = "^010\\d{8}$") String phone   // 010xxxxxxxx
) {}
