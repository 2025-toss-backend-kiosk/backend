package com.study.jskkiosk.auth.phone.sms;

/** 실제 문자 전송 구현체를 스위칭하기 위한 SPI */
public interface SmsSender {
    void send(String phone, String text);
}
