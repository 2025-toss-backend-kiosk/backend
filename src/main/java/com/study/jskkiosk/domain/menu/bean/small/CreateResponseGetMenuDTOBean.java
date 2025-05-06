package com.study.jskkiosk.domain.menu.bean.small;

import com.study.jskkiosk.domain.menu.entity.MenuItemEntity;
import com.study.jskkiosk.domain.menu.entity.dto.ResponseGetMenuAllDTO;
import com.study.jskkiosk.domain.menu.entity.dto.ResponseGetMenuDetailDTO;
import org.springframework.stereotype.Component;

@Component
public class CreateResponseGetMenuDTOBean {
    public ResponseGetMenuAllDTO execCategory(MenuItemEntity menuItemCategory) {
        return ResponseGetMenuAllDTO.builder()
                .menuItemId(menuItemCategory.getMenuItemId())
                .name(menuItemCategory.getName())
                .basePrice(menuItemCategory.getBasePrice())
                .isSoldOut(menuItemCategory.isSoldOut())
                .build();
    }

    public ResponseGetMenuDetailDTO execDetail(MenuItemEntity menuItemDetail) {
        return ResponseGetMenuDetailDTO.builder()
                .menuItemId(menuItemDetail.getMenuItemId())
                .name(menuItemDetail.getName())
                .basePrice(menuItemDetail.getBasePrice())
                .isSoldOut(menuItemDetail.isSoldOut())
                .build();
    }
}
