package com.ayit.my.shop.web.api.web.Controller;

import com.ayit.my.shop.domain.TbUser;
import com.ayit.my.shop.utils.persistence.BaseResult;
import com.ayit.my.shop.utils.validator.BeanValidator;
import com.ayit.my.shop.web.api.service.ITbUserService;
import com.ayit.my.shop.web.api.web.dto.TbUserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping(value = "${api.context.v1}/users")
public class tbUserController {

    @Autowired
    private ITbUserService userService;

    @RequestMapping(value="/login" ,method  = RequestMethod.POST)
    public BaseResult login(TbUser tbUser){
        TbUser user = userService.login(tbUser);
        if(user == null){
            return BaseResult.fail("用户名或密码错误");

        }else{
            TbUserDto dto =new TbUserDto();
            BeanUtils.copyProperties(user,dto);
            return BaseResult.success("登录成功",dto);
        }
    }

    @RequestMapping(value = "/register", method=RequestMethod.POST)
    public BaseResult save(TbUser tbUser){

        BaseResult baseResult = userService.insert(tbUser);
        return baseResult;

    }






}
