package com.study.jskkiosk.member.dto;

import com.study.jskkiosk.member.domain.Member;

public record MemberDto(
        Long   id,
        String phone,
        String nickname,
        int    points,
        int    stamps,
        String role,
        String memberType
) {
    public static MemberDto of(Member m) {
        return new MemberDto(
                m.getMemberId(),         // 자동 생성된 getter
                m.getPhone(),
                m.getNickname(),
                m.getPoints(),
                m.getStamps(),
                m.getRole().name(),      // Role enum 의 name()
                m.getMemberType().name() // MemberType enum 의 name()
        );
    }
}

