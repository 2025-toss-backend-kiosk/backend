package com.study.jskkiosk.auth.phone.service;

import com.study.jskkiosk.auth.phone.domain.PhoneAuth;
import com.study.jskkiosk.auth.phone.dto.*;
import com.study.jskkiosk.auth.phone.repository.PhoneAuthRepository;
import com.study.jskkiosk.auth.phone.sms.SmsSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class PhoneAuthService {

    private final PhoneAuthRepository repo;
    private final SmsSender           smsSender;
    private final Random              rnd = new Random();

    /* ------------- 인증번호 발송 -------------- */
    @Transactional
    public PhoneAuthResponse sendCode(SendCodeRequest req) {

        // 1) 6자리 난수
        String code = String.format("%06d", rnd.nextInt(1_000_000));

        // 2) 기존 row 있으면 재사용, 없으면 생성
        PhoneAuth auth = repo.findByPhone(req.phone())
                .orElseGet(() -> new PhoneAuth(req.phone()));

        // 3) 값 갱신
        auth.setCode(code);
        auth.setVerified(false);
        auth.setExpiresAt(LocalDateTime.now().plusMinutes(10));

        // 4) 저장
        repo.save(auth);

        // 5) (모의) SMS 발송
        smsSender.send(req.phone(), "인증번호 [" + code + "] 를 입력해주세요.");

        return new PhoneAuthResponse(true, "전송 완료");
    }

    /* ------------- 인증번호 확인 -------------- */
    @Transactional
    public PhoneAuthResponse verifyCode(VerifyCodeRequest req) {

        return repo.findByPhone(req.phone())
                .filter(a -> {           // 아직 인증 전인가
                    log.info("입력:{} / 저장:{}, 만료:{}, verified:{}",
                            req.code(), a.getCode(), a.getExpiresAt(), a.isVerified());
                    return !a.isVerified();
                })
                .filter(a -> a.getCode().equals(req.code()))               // 코드 일치?
                .filter(a -> a.getExpiresAt().isAfter(LocalDateTime.now()))// 유효 시간?
                .map(a -> {
                    a.markVerified();
                    return new PhoneAuthResponse(true, "인증 성공");
                })
                .orElseGet(() -> new PhoneAuthResponse(false, "인증 실패"));
    }
}
