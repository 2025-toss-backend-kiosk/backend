package com.study.jskkiosk.common.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    INVALID_PHONE(HttpStatus.BAD_REQUEST, "유효하지 않은 전화번호입니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "회원을 찾을 수 없습니다."),
    AUTH_CODE_MISMATCH(HttpStatus.UNAUTHORIZED, "인증 코드가 일치하지 않습니다."),
    AUTH_CODE_EXPIRED(HttpStatus.UNAUTHORIZED, "인증 코드가 만료되었습니다.");

    private final HttpStatus status;
    private final String message;

    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
