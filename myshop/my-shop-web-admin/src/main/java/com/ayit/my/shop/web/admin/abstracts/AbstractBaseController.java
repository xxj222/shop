package com.ayit.my.shop.web.admin.abstracts;

import com.ayit.my.shop.utils.PageInfo;
import com.ayit.my.shop.utils.persistence.BaseEntity;
import com.ayit.my.shop.utils.persistence.BaseResult;
import com.ayit.my.shop.utils.persistence.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

public  abstract class AbstractBaseController<S extends BaseService,T extends BaseEntity>  {

    @Autowired
    protected  S service;

    public abstract String list(Model model);

    public abstract  String from();
    public abstract String list(T entity , Model model , RedirectAttributes redirectAttributes);

    public abstract BaseResult delete(String ids);

    public abstract PageInfo<T> page(HttpServletRequest request, T entity);

    public abstract String detail(T  entity);


}
