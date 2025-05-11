package com.study.jskkiosk.member.controller.admin;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import lombok.RequiredArgsConstructor;
import com.study.jskkiosk.member.dto.MemberUpdateDto;
import com.study.jskkiosk.member.dto.MemberDto;
import com.study.jskkiosk.member.service.MemberService;


@RestController
@RequestMapping("/api/admin/members")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class MemberAdminController {

    private final MemberService memberService;

    // 조회
    @GetMapping("/{id}")
    public MemberDto get(@PathVariable("id") Long id) {
        return memberService.get(id);
    }

    // 수정 (PATCH)
    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable("id") Long id,
            @Valid @RequestBody MemberUpdateDto dto) {

        memberService.update(id, dto);
        return ResponseEntity.noContent().build();
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        memberService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
