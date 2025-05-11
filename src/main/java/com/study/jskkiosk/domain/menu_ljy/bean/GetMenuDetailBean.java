package com.study.jskkiosk.domain.menu_ljy.bean;

import com.study.jskkiosk.domain.menu_ljy.bean.small.CreateResponseGetMenuDTOBean;
import com.study.jskkiosk.domain.menu_ljy.bean.small.GetMenuItemEntityBean;
import com.study.jskkiosk.domain.menu_ljy.entity.MenuItemEntity;
import com.study.jskkiosk.domain.menu_ljy.entity.dto.ResponseGetMenuDetailDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
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
