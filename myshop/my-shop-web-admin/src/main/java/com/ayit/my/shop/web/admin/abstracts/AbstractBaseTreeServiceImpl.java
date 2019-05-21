package com.ayit.my.shop.web.admin.abstracts;

import com.ayit.my.shop.utils.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractBaseTreeServiceImpl<T extends BaseEntity,D extends BaseTreeDao<T>> implements BaseTreeService<T> {

    @Autowired
    protected D dao;

    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }



    @Override
    public T selectById(long id) {
        return dao.selectById(id);
    }



    /**
     *
     * 批量删除
     * @param ids
     */
    @Override
    public void deleteMulti(String[] ids){
        dao.deleteMulti(ids);
    };


    @Override
    public void update(T entity) {
        dao.update(entity);

    }

    @Override
    public List<T> selectAllById(Long id) {
        return dao.selectAllById(id);
    }


}
