package com.ayit.my.shop.web.api.service.impl;

import com.ayit.my.shop.domain.TbContent;
import com.ayit.my.shop.domain.TbContentCategory;
import com.ayit.my.shop.web.api.dao.ITbContentDao;
import com.ayit.my.shop.web.api.service.ITbContectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(readOnly = true)
@Service
public class TbContentImpl implements ITbContectService {

    @Autowired
    private ITbContentDao tbContentDao;

    @Override
    public List<TbContent> selectById(Long categoryId) {
        TbContentCategory contentCategory = new TbContentCategory();
        contentCategory.setId(categoryId);
        TbContent tbContent = new TbContent();
        tbContent.setTbContentCategory(contentCategory);
        return tbContentDao.selectById(tbContent);
    }
}
