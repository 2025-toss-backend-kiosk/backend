package com.study.jskkiosk.auth.phone.sms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Slf4j
@Primary        // 우선 선택되는 빈
@Component
public class MockSmsSender implements SmsSender {

    @Override
    public void send(String phone, String text) {
        log.info("[MOCK‑SMS] to={} | {}", phone, text);
    }
}
