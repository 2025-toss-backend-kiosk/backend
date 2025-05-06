package com.study.jskkiosk.auth.phone.controller;

import com.study.jskkiosk.auth.phone.dto.*;
import com.study.jskkiosk.auth.phone.service.PhoneAuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/phones")
@RequiredArgsConstructor
public class PhoneAuthController {

    private final PhoneAuthService service;

    /** ① 인증번호 발송 */
    @PostMapping
    public PhoneAuthResponse send(@RequestBody @Valid SendCodeRequest req) {
        return service.sendCode(req);
    }

    /** ② 인증번호 확인 */
    @PostMapping("/verify")
    public PhoneAuthResponse verify(@RequestBody @Valid VerifyCodeRequest req) {
        return service.verifyCode(req);
    }
}
