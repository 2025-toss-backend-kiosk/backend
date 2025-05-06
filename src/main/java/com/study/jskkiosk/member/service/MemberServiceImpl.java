package com.study.jskkiosk.member.service;

import com.study.jskkiosk.member.domain.Member;
import com.study.jskkiosk.member.dto.MemberDto;
import com.study.jskkiosk.member.dto.MemberUpdateDto;
import com.study.jskkiosk.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository repo;

    @Override
    public MemberDto get(Long memberId) {
        Member m = repo.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("회원이 없습니다. id=" + memberId));
        return MemberDto.of(m);
    }

    @Override
    public void update(Long memberId, MemberUpdateDto dto) {
        Member m = repo.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException("회원이 없습니다. id=" + memberId));
        m.apply(dto);  // 엔티티에서 필드 반영
    }

    @Override
    public void delete(Long memberId) {
        repo.deleteById(memberId);
    }
}
