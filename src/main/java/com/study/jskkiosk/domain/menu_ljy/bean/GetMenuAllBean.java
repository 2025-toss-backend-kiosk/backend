package com.study.jskkiosk.domain.menu_ljy.bean;

import com.study.jskkiosk.domain.menu_ljy.bean.small.CreateResponseGetMenuDTOBean;
import com.study.jskkiosk.domain.menu_ljy.bean.small.GetMenuItemEntityBean;
import com.study.jskkiosk.domain.menu_ljy.entity.MenuItemEntity;
import com.study.jskkiosk.domain.menu_ljy.entity.dto.ResponseGetMenuAllDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetMenuAllBean {

    private GetMenuItemEntityBean getMenuItemEntityBean;
    private CreateResponseGetMenuDTOBean createResponseGetMenuDTOBean;

    public GetMenuAllBean(GetMenuItemEntityBean getMenuItemEntityBean, CreateResponseGetMenuDTOBean createResponseGetMenuDTOBean) {
        this.getMenuItemEntityBean = getMenuItemEntityBean;
        this.createResponseGetMenuDTOBean = createResponseGetMenuDTOBean;
    }

    public List<ResponseGetMenuAllDTO> exec(String category) {
        UUID categoryId = UUID.fromString(category);

        //public List<MenuItemEntity> exec(UUID categoryId) {
        //    return menuRepositoryJPA.findAllByCategoryId(categoryId);
        //}

        List<MenuItemEntity> menuItemEntityList = getMenuItemEntityBean.execByCategoryId(categoryId);
        return menuItemEntityList.stream()
                .map(createResponseGetMenuDTOBean::execCategory)
                .toList();
    }


}
