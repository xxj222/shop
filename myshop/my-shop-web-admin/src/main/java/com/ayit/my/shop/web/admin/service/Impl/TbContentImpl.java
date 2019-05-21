package com.ayit.my.shop.web.admin.service.Impl;

import com.ayit.my.shop.utils.PageInfo;
import com.ayit.my.shop.utils.persistence.BaseResult;
import com.ayit.my.shop.domain.TbContent;

import com.ayit.my.shop.utils.validator.BeanValidator;
import com.ayit.my.shop.web.admin.abstracts.AbstractBaseServiceImpl;
import com.ayit.my.shop.web.admin.dao.ITbContent;
import com.ayit.my.shop.web.admin.service.ITbContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;



@Service
@Transactional(readOnly = true)
public class TbContentImpl extends AbstractBaseServiceImpl<TbContent,ITbContent> implements ITbContentService {



    @Autowired
    private ITbContent contentDao;



    @Override
    @Transactional(readOnly = false)
    public BaseResult Save(TbContent tbContent) {
        String validator = BeanValidator.validator(tbContent);
        if(validator != null){
            return BaseResult.fail(validator);
        }
        //        判断是否通过验证，如果通过验证再进行保存操作
        else{
            tbContent.setUpdated(new Date());
            //          新增
            if(tbContent.getId() == null){

                tbContent.setCreated(new Date());
                contentDao.insert(tbContent);
            }
//        更新
            else{
                contentDao.update(tbContent);
            }
            return BaseResult.success("保存内容成功");
        }

    }













}
