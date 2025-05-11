package com.study.jskkiosk.auth.phone.sms;

import org.springframework.stereotype.Component;

/**
 *  네이버 Cloud SMS 연동 (TODO)
 *  - 아직은 예시로 로그만 출력
 */
@Component
public class NcpSmsSender implements SmsSender {

    @Override
    public void send(String to, String text) {
        // TODO: NCP SDK 호출 코드 작성
        System.out.println("[NCP‑SMS] to=" + to + " | " + text);
    }
}
