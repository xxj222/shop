package com.ayit.my.shop.web.admin.abstracts;

import com.ayit.my.shop.utils.PageInfo;
import com.ayit.my.shop.utils.persistence.BaseDao;
import com.ayit.my.shop.utils.persistence.BaseEntity;
import com.ayit.my.shop.utils.persistence.BaseResult;
import com.ayit.my.shop.utils.persistence.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractBaseServiceImpl  <T extends BaseEntity,D extends BaseDao<T>> implements BaseService<T> {


    @Autowired
    protected D dao;
    @Override
    public List<T> selectAll() {
        return dao.selectAll();
    }


//    @Override
//    public BaseResult Save(T entity) {
//        return dao.insert(em);
//    }

    @Override
    public T selectById(long id) {
        return dao.selectById(id);
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }

    @Override
    public void update(T entity) {
        dao.update(entity);
    }

    @Override
    public void deleteMulti(String[] ids) {
        dao.deleteMulti(ids);

    }
    @Override
    public int count(T entity) {
        return dao.count(entity);
    }


    @Override
    public PageInfo<T> queryPage(int start, int length, int draw, T entity) {
        PageInfo<T> pageInfo = new PageInfo<>();
        int count = dao.count(entity);
        Map<String, Object> map = new HashMap<>();


        map.put("start",start);
        map.put("length",length);
        map.put("pageParams",entity);

        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setError("");
        pageInfo.setData(dao.queryPage(map));
        return pageInfo;
    }



}
