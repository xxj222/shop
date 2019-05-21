package com.ayit.my.shop.web.admin.service.Impl;

import com.ayit.my.shop.domain.TbContentCategory;
import com.ayit.my.shop.utils.persistence.BaseResult;
import com.ayit.my.shop.utils.validator.BeanValidator;
import com.ayit.my.shop.web.admin.abstracts.AbstractBaseTreeServiceImpl;
import com.ayit.my.shop.web.admin.dao.ITbContentCategory;
import com.ayit.my.shop.web.admin.service.ITbContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional(readOnly = true)
public class TbContentCategoryImpl extends AbstractBaseTreeServiceImpl<TbContentCategory,ITbContentCategory> implements ITbContentCategoryService {

    @Autowired
    private ITbContentCategory contentCategoryDao;



    @Override
    @Transactional(readOnly = false)
    public BaseResult Save(TbContentCategory entity) {

//        验证
        String validator = BeanValidator.validator(entity);
        if(validator != null){
            return BaseResult.fail(validator);
        }
        else{
            entity.setUpdated(new Date());
//            新增分类列表
            if(entity.getId()  == null){
                if(entity.getParentCategory().getId() ==  null){
//                    新增第一级父级类目
                    entity.setParentId(0L);
                    entity.setParent(true);
                }
//                新增的非一级菜单
                else{


                    TbContentCategory  currentCategory =  entity.getParentCategory();
                    if(currentCategory.getId() != 0L){
                        TbContentCategory tbContentCategory = contentCategoryDao.selectById(currentCategory.getId());
                        currentCategory.setParentId(tbContentCategory.getParentId());
                        currentCategory.setParent(true);
                        update(currentCategory);
                    }
                    entity.setParentId(currentCategory.getId());



                }
                entity.setCreated(new Date());
                contentCategoryDao.insert(entity);
            }
//          更新分类列表
            else{
                contentCategoryDao.update(entity);
            }
            return BaseResult.success("保存分类成功");
        }


    }


}
