package com.study.jskkiosk.member.domain;

import com.study.jskkiosk.member.domain.enums.*;
import com.study.jskkiosk.member.dto.MemberUpdateDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "member")
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String phone;
    private String passwordHash;
    private String nickname;

    private int points;
    private int stamps;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    public void apply(MemberUpdateDto dto) {
        if (dto.nickname() != null) this.nickname = dto.nickname();
        if (dto.points() != null) this.points = dto.points();
        if (dto.stamps() != null) this.stamps = dto.stamps();
    }

    public void addPoints(int amount) {
        this.points += amount;
    }

    public void usePoints(int amount) {
        this.points -= amount;
    }
}
