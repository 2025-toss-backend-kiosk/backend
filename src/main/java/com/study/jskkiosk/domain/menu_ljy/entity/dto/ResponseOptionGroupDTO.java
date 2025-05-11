package com.study.jskkiosk.domain.menu_ljy.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseOptionGroupDTO {
    private String groupId;
    private String groupName;
    private int minSelect;
    private int maxSelect;
    private List<ResponseOptionDTO> options;
}
