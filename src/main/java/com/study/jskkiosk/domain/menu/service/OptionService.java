package com.study.jskkiosk.domain.menu.service;

import com.study.jskkiosk.domain.menu.bean.small.CreateResponseMenuOptionGroupBean;
import com.study.jskkiosk.domain.menu.entity.OptionEntity;
import com.study.jskkiosk.domain.menu.entity.OptionGroupEntity;
import com.study.jskkiosk.domain.menu.entity.dto.ResponseOptionGroupDTO;
import com.study.jskkiosk.domain.menu.repository.OptionGroupRepositoryJPA;
import com.study.jskkiosk.domain.menu.repository.OptionRepositoryJPA;
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

    public List<ResponseOptionGroupDTO> getOptionsByMenuId(UUID menuId) {
        List<OptionGroupEntity> groups = optionGroupRepo.findAllByMenuItemId(menuId);

        return groups.stream()
                .map(group -> {
                    List<OptionEntity> options = optionRepo.findAllByGroupId(group.getGroupId());
                    return optionGroupBean.from(group, options);
                })
                .collect(Collectors.toList());
    }
}
