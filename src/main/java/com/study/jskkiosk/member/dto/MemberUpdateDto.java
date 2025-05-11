package com.study.jskkiosk.member.dto;

public record MemberUpdateDto(
        String nickname,
        Integer points,
        Integer stamps
) {}