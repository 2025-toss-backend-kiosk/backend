package com.study.jskkiosk.common.exception;

public class JskKioskException extends RuntimeException {
    private final ErrorCode errorCode;

    public JskKioskException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
