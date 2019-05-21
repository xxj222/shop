package com.ayit.my.shop.web.admin.service.Impl;

import com.ayit.my.shop.utils.PageInfo;
import com.ayit.my.shop.utils.RegexpUtils;
import com.ayit.my.shop.utils.persistence.BaseResult;
import com.ayit.my.shop.domain.TbUser;

import com.ayit.my.shop.utils.validator.BeanValidator;
import com.ayit.my.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import com.ayit.my.shop.web.admin.abstracts.AbstractBaseTreeServiceImpl;
import com.ayit.my.shop.web.admin.dao.ITbUserDao;
import com.ayit.my.shop.web.admin.service.ITbUserServicve;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = true)
public class TbUserServiceImpl extends AbstractBaseServiceImpl<TbUser,ITbUserDao> implements ITbUserServicve {




    @Autowired
    private ITbUserDao tbUserDao;




    @Override
    @Transactional(readOnly = false)
    public TbUser login(String email,String password) {
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        TbUser tbuser = tbUserDao.getByEmail(email);
        if(tbuser != null){
            if(md5Password.equals(tbuser.getPassword())){
                return tbuser;
            }
            else{
                return null;
            }
        }
        return null;
    }

    @Override
    public BaseResult Save(TbUser tbUser) {


//        BaseResult baseResult = checkUser(tbUser);

        String validator = BeanValidator.validator(tbUser);

        if (validator != null) {
            return BaseResult.fail(validator);


        } else {
            tbUser.setUpdated(new Date());
            //          新增
            if (tbUser.getId() == null) {

                tbUser.setCreated(new Date());
                tbUserDao.insert(tbUser);
            }
//        更新
            else {
                tbUserDao.update(tbUser);
            }
            return BaseResult.success();

        }

    }








}
