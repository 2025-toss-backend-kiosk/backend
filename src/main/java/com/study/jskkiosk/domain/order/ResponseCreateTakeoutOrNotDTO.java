package com.study.jskkiosk.domain.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseCreateTakeoutOrNotDTO {
    private String orderType; // "DINEIN" 또는 "TAKEOUT"
    private Long memberId; // 회원 ID (로그인한 경우)
}
