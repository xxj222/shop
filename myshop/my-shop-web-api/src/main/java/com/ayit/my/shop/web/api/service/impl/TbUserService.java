package com.ayit.my.shop.web.api.service.impl;

import com.ayit.my.shop.domain.TbUser;
import com.ayit.my.shop.utils.persistence.BaseResult;
import com.ayit.my.shop.utils.validator.BeanValidator;
import com.ayit.my.shop.web.api.dao.ITbUserDao;
import com.ayit.my.shop.web.api.service.ITbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class TbUserService implements ITbUserService {

    @Autowired
    private ITbUserDao userDao;

    /**
     * 登录
     * @param tbUser
     * @return
     */
    @Override
    public TbUser login(TbUser tbUser) {
        return userDao.login(tbUser);
    }

    /**
     * 新增
     * @param tbUser
     */
    @Override
    public BaseResult insert(TbUser tbUser) {
        String validator = BeanValidator.validator(tbUser);
        if(validator != null){
            return BaseResult.fail(validator);
        }
        else{
            tbUser.setCreated(new Date());
            tbUser.setUpdated(new Date());
            userDao.insert(tbUser);

            return BaseResult.success("注册成功,请登录");

        }

    }
}
