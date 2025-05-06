package com.study.jskkiosk.domain.menu.service;

import com.study.jskkiosk.domain.menu.bean.GetMenuAllBean;
import com.study.jskkiosk.domain.menu.bean.GetMenuDetailBean;
import com.study.jskkiosk.domain.menu.entity.dto.ResponseGetMenuAllDTO;
import com.study.jskkiosk.domain.menu.entity.dto.ResponseGetMenuDetailDTO;

import java.util.List;
import java.util.UUID;

public class MenuService {

    private final GetMenuAllBean getMenuAllBean;
    private final GetMenuDetailBean getMenuDetailBean;

    public MenuService(GetMenuAllBean getMenuAllBean, GetMenuDetailBean getMenuDetailBean) {
        this.getMenuAllBean = getMenuAllBean;
        this.getMenuDetailBean = getMenuDetailBean;
    }

    public List<ResponseGetMenuAllDTO> getAll(String category) {
        return getMenuAllBean.exec(category);
    }

    public ResponseGetMenuDetailDTO getDetail(UUID menuItemId) {
        return getMenuDetailBean.exec(menuItemId);
    }
}
