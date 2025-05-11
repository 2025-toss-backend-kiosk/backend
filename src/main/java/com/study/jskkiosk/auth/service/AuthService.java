package com.study.jskkiosk.auth.service;

import com.study.jskkiosk.auth.dto.*;

public interface AuthService {
    TokenResponse join(MemberJoinRequest request);
    TokenResponse login(MemberLoginRequest request);
}
