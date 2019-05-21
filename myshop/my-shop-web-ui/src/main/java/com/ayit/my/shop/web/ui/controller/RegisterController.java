package com.ayit.my.shop.web.ui.controller;

import com.ayit.my.shop.utils.MapperUtil;
import com.ayit.my.shop.utils.persistence.BaseResult;
import com.ayit.my.shop.web.ui.api.UserAPI;
import com.ayit.my.shop.web.ui.dto.TbUser;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(TbUser  tbUser, Model model, RedirectAttributes redirectAttributes){
        if(!StringUtils.equals(tbUser.getPassword(),tbUser.getCheckpwd())){
            BaseResult baseResult = BaseResult.fail("两次密码输入不一致，请重新输入");
            model.addAttribute("baseResult",baseResult);
            return "register";
        }

        String result = UserAPI.register(tbUser);
        BaseResult baseResult = null;
        try {
            baseResult = MapperUtil.json2pojo(result, BaseResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }


        if(baseResult.getStatus() == 200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/login";
        }else{
            model.addAttribute("baseResult",baseResult);
            return "register";
        }


    }


}
