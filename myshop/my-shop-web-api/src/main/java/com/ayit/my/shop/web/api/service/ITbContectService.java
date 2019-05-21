package com.ayit.my.shop.web.api.service;

import com.ayit.my.shop.domain.TbContent;

import java.util.List;

public interface ITbContectService {

    /**
     * 通过ID查询相关数据
     * @param id
     * @return
     */
    public List<TbContent> selectById(Long id);
}
