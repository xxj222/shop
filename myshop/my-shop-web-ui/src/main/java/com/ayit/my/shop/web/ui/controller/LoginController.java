package com.ayit.my.shop.web.ui.controller;

import com.ayit.my.shop.utils.persistence.BaseResult;
import com.ayit.my.shop.web.ui.api.UserAPI;
import com.ayit.my.shop.web.ui.dto.TbUser;
import com.google.code.kaptcha.Constants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller

public class LoginController {

    @RequestMapping(value  =  "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(TbUser tbUser, Model model, HttpServletRequest request){

        if(!checkVarification(tbUser,request)){
            model.addAttribute("baseResult", BaseResult.fail("验证码错误"));
            return "login";
        }

        TbUser user = UserAPI.login(tbUser);
        if(user == null){

            model.addAttribute("baseResult", BaseResult.fail("用户名或密码错误"));
            return "login";
        }else {
            request.getSession().setAttribute("tbUser",user);
            return "redirect:/index";
        }
    }

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
//       使session失效
        request.getSession().invalidate();
        return "redirect:login";
    }


    public Boolean checkVarification(TbUser tbUser,HttpServletRequest request){
        String verification = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(StringUtils.equals(verification,tbUser.getVerificode())){
            return true;
        }
        return false;
    }


}
