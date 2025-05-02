package com.study.jskkiosk.domain.menu.bean;

import com.study.jskkiosk.domain.menu.bean.small.CreateResponseGetMenuDTOBean;
import com.study.jskkiosk.domain.menu.bean.small.GetMenuItemEntityBean;
import com.study.jskkiosk.domain.menu.entity.MenuItemEntity;
import com.study.jskkiosk.domain.menu.entity.dto.ResponseGetMenuAllDTO;

import java.util.List;

public class GetMenuAllBean {

    private GetMenuItemEntityBean getMenuItemEntityBean;
    private CreateResponseGetMenuDTOBean createResponseGetMenuDTOBean;

    public GetMenuAllBean(GetMenuItemEntityBean getMenuItemEntityBean, CreateResponseGetMenuDTOBean createResponseGetMenuDTOBean) {
        this.getMenuItemEntityBean = getMenuItemEntityBean;
        this.createResponseGetMenuDTOBean = createResponseGetMenuDTOBean;
    }

    public List<ResponseGetMenuAllDTO> exec(String category) {

        List<MenuItemEntity> menuItemEntityList;
        menuItemEntityList = getMenuItemEntityBean.exec(category);

        List<ResponseGetMenuAllDTO> items = menuItemEntityList.stream().map(createResponseGetMenuDTOBean::execCategory).toList();

        return items;

    }
}
