package com.ayit.my.shop.web.admin.web.controller;


import com.ayit.my.shop.utils.CookieUtils;
import com.ayit.my.shop.domain.TbUser;

import com.ayit.my.shop.web.admin.abstracts.AbstractBaseController;
import com.ayit.my.shop.web.admin.service.ITbUserServicve;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController  {

    @Autowired
   private ITbUserServicve tbUserServicve;


    /**
     * 实现跳转
     *
     * @param
     * @param
     * @return
     */

    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {


        return "login";
    }

    /**
     * 登录逻辑
     *
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password , HttpServletRequest httpservletrequest, HttpServletResponse httpServletResponse , Model model) {


        Boolean isRmember = httpservletrequest.getParameter("isRmember")==null?true:false;

        TbUser user = tbUserServicve.login(email, password);
        if(user !=  null) {
//            记住我
            if (!isRmember) {
                CookieUtils.setCookie(httpservletrequest, httpServletResponse, "userInfo", String.format("%s:%s", email, password), 7 * 24 * 3600);
            }
//            不记住
            else {
                CookieUtils.deleteCookie(httpservletrequest, httpServletResponse, "userInfo");
            }
            //往seesion中传值
            httpservletrequest.getSession().setAttribute("user", user);
            return "redirect:/main";

//            登录失败

        }
        else {
//            失败跳转登录页
            model.addAttribute("message","用户名或密码错误！");
            return "login";
        }
//


    }

    /**
     * 登出系统
     * @param httpServletRequest
     */
    @RequestMapping(value = "logout" ,method = RequestMethod.GET)
    public String logout(HttpServletRequest httpServletRequest){
//        使session失效
        String userInfo = CookieUtils.getCookieValue(httpServletRequest,"userInfo");
        String[] userInfoArray = userInfo.split(":");
        if (userInfo  != null && userInfo !=""){
            httpServletRequest.setAttribute("email",userInfoArray[0]);
            httpServletRequest.setAttribute("password",userInfoArray[1]);
        }
        httpServletRequest.getSession().invalidate();
//        登出后返回登录页
         return "login";
    }

}
