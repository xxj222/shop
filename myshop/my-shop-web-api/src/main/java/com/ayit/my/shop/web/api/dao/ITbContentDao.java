package com.ayit.my.shop.web.api.dao;

import com.ayit.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITbContentDao {

    /**
     * 通过ID查询相关数据
     * @param tbContent
     * @return
     */
    public List<TbContent> selectById(TbContent tbContent);

}
