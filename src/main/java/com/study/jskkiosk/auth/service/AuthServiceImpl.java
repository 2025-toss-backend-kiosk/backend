package com.study.jskkiosk.auth.service;

import com.study.jskkiosk.auth.dto.*;
import com.study.jskkiosk.auth.security.JwtProvider;
import com.study.jskkiosk.member.domain.Member;
import com.study.jskkiosk.member.domain.enums.MemberType;
import com.study.jskkiosk.member.domain.enums.Role;
import com.study.jskkiosk.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

    private final MemberRepository memberRepository;
    private final JwtProvider jwtProvider;

    @Override
    public TokenResponse join(MemberJoinRequest request) {
        if (memberRepository.findByPhone(request.phone()).isPresent()) {
            throw new IllegalArgumentException("이미 등록된 전화번호입니다.");
        }

        Member member = Member.builder()
                .phone(request.phone())
                .nickname(request.nickname())
                .role(Role.USER)
                .memberType(MemberType.MEMBER)
                .build();

        Member saved = memberRepository.save(member);
        return new TokenResponse(jwtProvider.createToken(saved.getMemberId().toString()));
    }

    @Override
    public TokenResponse login(MemberLoginRequest request) {
        Member member = memberRepository.findByPhone(request.phone())
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));
        return new TokenResponse(jwtProvider.createToken(member.getMemberId().toString()));
    }
}

