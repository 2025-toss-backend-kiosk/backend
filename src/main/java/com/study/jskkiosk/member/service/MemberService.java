package com.study.jskkiosk.member.service;

import com.study.jskkiosk.member.dto.MemberDto;
import com.study.jskkiosk.member.dto.MemberUpdateDto;

public interface MemberService {
    MemberDto get(Long memberId);
    void update(Long memberId, MemberUpdateDto dto);
    void delete(Long memberId);
}