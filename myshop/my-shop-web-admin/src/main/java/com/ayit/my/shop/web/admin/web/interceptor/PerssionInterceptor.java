package com.ayit.my.shop.web.admin.web.interceptor;


import com.ayit.my.shop.domain.TbUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PerssionInterceptor  implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        if(modelAndView!=null && modelAndView.getViewName()!= null&&  modelAndView.getViewName().endsWith("login")){
            TbUser user = (TbUser) httpServletRequest.getSession().getAttribute("user");
            if(user != null){
                httpServletResponse.sendRedirect("/main");
            }
        }

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
