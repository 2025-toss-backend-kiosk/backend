package com.study.jskkiosk.domain.menu.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseOptionGroupDTO {
    private UUID groupId;
    private String groupName;
    private int minSelect;
    private int maxSelect;
    private List<ResponseOptionDTO> options;
}
