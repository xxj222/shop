package com.ayit.my.shop.web.ui.controller;

import com.ayit.my.shop.utils.HttpClientUtil;
import com.ayit.my.shop.utils.MapperUtil;
import com.ayit.my.shop.web.ui.api.ContentAPI;
import com.ayit.my.shop.web.ui.api.UserAPI;
import com.ayit.my.shop.web.ui.dto.TbContent;
import com.ayit.my.shop.web.ui.dto.TbUser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller

public class IndexController {

    @RequestMapping(value = {"","/index"},method = RequestMethod.GET)
    public String index(Model model){
        List<TbContent> ppt = ContentAPI.PPTAPI(89);
        model.addAttribute("ppt",ppt);

        return "index";
    }




}
