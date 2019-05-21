package com.ayit.my.shop.web.api.service;

import com.ayit.my.shop.domain.TbUser;
import com.ayit.my.shop.utils.persistence.BaseResult;

public interface ITbUserService {
    /**
     * 登录
     * @param tbUser
     * @return
     */

    public TbUser login(TbUser tbUser);

    /**
     * 新增数据
     * @param tbUser
     */
    public BaseResult insert(TbUser tbUser);
}
