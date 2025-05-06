package com.study.jskkiosk.auth.phone.dto;

/** 공통 응답 */
public record PhoneAuthResponse(
        boolean success,
        String  message
) {}
