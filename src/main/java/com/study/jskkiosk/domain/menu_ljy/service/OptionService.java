package com.study.jskkiosk.domain.menu_ljy.service;

import com.study.jskkiosk.domain.menu_ljy.bean.small.CreateResponseMenuOptionGroupBean;
import com.study.jskkiosk.domain.menu_ljy.entity.OptionEntity;
import com.study.jskkiosk.domain.menu_ljy.entity.OptionGroupEntity;
import com.study.jskkiosk.domain.menu_ljy.entity.dto.ResponseOptionGroupDTO;
import com.study.jskkiosk.domain.menu_ljy.repository.OptionGroupRepositoryJPA;
import com.study.jskkiosk.domain.menu_ljy.repository.OptionRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OptionService {

    private final OptionGroupRepositoryJPA optionGroupRepo;
    private final OptionRepositoryJPA optionRepo;
    private final CreateResponseMenuOptionGroupBean optionGroupBean;

    public List<ResponseOptionGroupDTO> getOptionsByMenuId(String menuId) {
        List<OptionGroupEntity> groups = optionGroupRepo.findAllByMenuItemId(menuId);

        return groups.stream()
                .map(group -> {
                    List<OptionEntity> options = optionRepo.findAllByGroupId(group.getGroupId());
                    return optionGroupBean.from(group, options);
                })
                .collect(Collectors.toList());
    }
}
