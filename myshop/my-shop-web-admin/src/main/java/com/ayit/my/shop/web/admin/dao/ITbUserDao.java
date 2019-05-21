package com.ayit.my.shop.web.admin.dao;

import com.ayit.my.shop.domain.TbUser;
import com.ayit.my.shop.utils.persistence.BaseDao;
import org.springframework.stereotype.Repository;



@Repository
public interface ITbUserDao extends  BaseDao<TbUser> {

    /**
     * 根据邮箱查询用户
     * @param email
     * @return
     */
    TbUser getByEmail(String email);



}
