package com.ayit.my.shop.web.api.dao;

import com.ayit.my.shop.domain.TbUser;
import org.springframework.stereotype.Repository;

@Repository
public interface ITbUserDao {

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
    public void insert(TbUser tbUser);

}
