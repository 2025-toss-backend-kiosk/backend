package com.study.jskkiosk.global.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponseDTO<T> {
    @Schema(description = "성공 여부", example = "true")
    private boolean isSuccess;

    @Schema(description = "응답 메시지", example = "요청 성공")
    private String message;

    @Schema(description = "응답 데이터")
    private T data;
}
