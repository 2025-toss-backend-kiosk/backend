package com.study.jskkiosk.domain.menu_ljy.bean.small;

import com.study.jskkiosk.domain.menu_ljy.entity.OptionEntity;
import com.study.jskkiosk.domain.menu_ljy.entity.OptionGroupEntity;
import com.study.jskkiosk.domain.menu_ljy.entity.dto.ResponseOptionDTO;
import com.study.jskkiosk.domain.menu_ljy.entity.dto.ResponseOptionGroupDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreateResponseMenuOptionGroupBean {

    public ResponseOptionGroupDTO from(OptionGroupEntity group, List<OptionEntity> options) {
        List<ResponseOptionDTO> optionDTOs = options.stream()
                .map(opt -> ResponseOptionDTO.builder()
                        .optionId(opt.getOptionId())
                        .name(opt.getName())
                        .addPrice(opt.getAddPrice())
                        .build())
                .collect(Collectors.toList());

        return ResponseOptionGroupDTO.builder()
                .groupId(group.getGroupId())
                .groupName(group.getName())
                .minSelect(group.getMinSel())
                .maxSelect(group.getMaxSel())
                .options(optionDTOs)
                .build();
    }
}