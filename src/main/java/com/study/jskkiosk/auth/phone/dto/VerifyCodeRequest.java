package com.study.jskkiosk.auth.phone.dto;

/** 인증번호 확인 요청 */
public record VerifyCodeRequest(
        String phone,
        String code
) {}
