package com.ayit.my.shop.web.ui.api;

import com.ayit.my.shop.utils.HttpClientUtil;
import com.ayit.my.shop.utils.MapperUtil;
import com.ayit.my.shop.web.ui.dto.TbContent;

import java.util.List;

public class ContentAPI {
    public static List<TbContent> PPTAPI(int id){
        List<TbContent> ppt = null;
        String result = HttpClientUtil.doGET(API.CONTENT_API+id);
        try {
             ppt = MapperUtil.json2listByTree(result, TbContent.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ppt;
    }
}
