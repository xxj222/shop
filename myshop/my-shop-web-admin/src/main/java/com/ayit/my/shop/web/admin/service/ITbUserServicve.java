package com.ayit.my.shop.web.admin.service;


import com.ayit.my.shop.domain.TbUser;
import com.ayit.my.shop.utils.persistence.BaseService;


public interface ITbUserServicve extends BaseService<TbUser> {


    TbUser login(String eamil,String password);


}
