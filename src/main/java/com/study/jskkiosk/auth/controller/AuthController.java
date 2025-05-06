package com.study.jskkiosk.auth.controller;

import com.study.jskkiosk.auth.dto.MemberJoinRequest;
import com.study.jskkiosk.auth.dto.MemberLoginRequest;
import com.study.jskkiosk.auth.dto.TokenResponse;
import com.study.jskkiosk.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // 회원가입
    @PostMapping("/join")
    public ResponseEntity<TokenResponse> join(@RequestBody MemberJoinRequest request) {
        return ResponseEntity.ok(authService.join(request));
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody MemberLoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
