package com.study.jskkiosk.member.domain;

import com.study.jskkiosk.member.dto.MemberUpdateDto;
import com.study.jskkiosk.member.domain.enums.Role;
import com.study.jskkiosk.member.domain.enums.MemberType;
import jakarta.persistence.*;
import lombok.*;

// ← 이 줄이 반드시 있어야 합니다!
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "member")
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;    // ← getMemberId() 생성

    private String phone;     // ← getPhone() 생성
    private String passwordHash;
    private String nickname;  // ← getNickname() 생성

    private int points;       // ← getPoints() 생성
    private int stamps;       // ← getStamps() 생성

    @Enumerated(EnumType.STRING)
    private Role role;        // ← getRole() 생성, Role.name() 도 가능

    @Enumerated(EnumType.STRING)
    private MemberType memberType; // ← getMemberType() 생성

    public void apply(MemberUpdateDto dto) {
        if (dto.nickname() != null) this.nickname = dto.nickname();
        if (dto.points()   != null) this.points   = dto.points();
        if (dto.stamps()   != null) this.stamps   = dto.stamps();
    }
}
