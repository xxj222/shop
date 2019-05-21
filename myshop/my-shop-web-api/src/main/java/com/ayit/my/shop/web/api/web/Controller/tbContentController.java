package com.ayit.my.shop.web.api.web.Controller;

import com.ayit.my.shop.domain.TbContent;
import com.ayit.my.shop.domain.TbContentCategory;
import com.ayit.my.shop.utils.persistence.BaseResult;
import com.ayit.my.shop.web.api.service.ITbContectService;
import com.ayit.my.shop.web.api.service.impl.TbContentImpl;
import com.ayit.my.shop.web.api.web.dto.TbContentDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "${api.context.v1}/content")
public class tbContentController {

    @Autowired
    private ITbContectService tbContentImpl;

    @ModelAttribute
    public TbContent getTbContent(Long id){
        TbContent tbContent = null;
        if(id == null){
            tbContent = new TbContent();
        }
        return tbContent;
    }

    @RequestMapping(value = "{category_id}",method= RequestMethod.GET)
    public BaseResult selectById(@PathVariable(value = "category_id") Long categoryId){
        List<TbContent> tbContents = tbContentImpl.selectById(categoryId);
        List<TbContentDto> tbContentDtos = new ArrayList<TbContentDto>() ;
        for (TbContent tbContent : tbContents) {
            TbContentDto dto = new TbContentDto();
            BeanUtils.copyProperties(tbContent,dto);
            tbContentDtos.add(dto);
        }

        return BaseResult.success("成功",tbContentDtos);
    }





}
