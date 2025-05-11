package com.study.jskkiosk.domain.menu_ljy.service;

import com.study.jskkiosk.domain.menu_ljy.bean.GetMenuAllBean;
import com.study.jskkiosk.domain.menu_ljy.bean.GetMenuDetailBean;
import com.study.jskkiosk.domain.menu_ljy.entity.dto.ResponseGetMenuAllDTO;
import com.study.jskkiosk.domain.menu_ljy.entity.dto.ResponseGetMenuDetailDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
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
