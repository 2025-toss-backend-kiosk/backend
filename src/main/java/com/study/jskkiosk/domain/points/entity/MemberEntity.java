package com.study.jskkiosk.domain.points.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "member")
public class MemberEntity {

    @Id
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "member_type")
    private String memberType;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "point")
    private Integer point;

    public void addPoints(int amount) {
        this.point += amount;
    }

    public void usePoints(int amount) {
        this.point -= amount;
    }
}
