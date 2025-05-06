package com.study.jskkiosk.domain.menu.bean;

import com.study.jskkiosk.domain.menu.bean.small.CreateResponseGetMenuDTOBean;
import com.study.jskkiosk.domain.menu.bean.small.GetMenuItemEntityBean;
import com.study.jskkiosk.domain.menu.entity.MenuItemEntity;
import com.study.jskkiosk.domain.menu.entity.dto.ResponseGetMenuDetailDTO;

import java.util.List;
import java.util.UUID;

public class GetMenuDetailBean {

    private GetMenuItemEntityBean getMenuItemEntityBean;
    private CreateResponseGetMenuDTOBean createResponseGetMenuDTOBean;

    public GetMenuDetailBean(GetMenuItemEntityBean getMenuItemEntityBean, CreateResponseGetMenuDTOBean createResponseGetMenuDTOBean) {
        this.getMenuItemEntityBean = getMenuItemEntityBean;
        this.createResponseGetMenuDTOBean = createResponseGetMenuDTOBean;
    }

    public ResponseGetMenuDetailDTO exec(UUID menuItemId) {
        MenuItemEntity menuItem = getMenuItemEntityBean.exec(menuItemId);

        return createResponseGetMenuDTOBean.execDetail(menuItem);

    }
}
