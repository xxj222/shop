package com.ayit.my.shop.web.admin.web.controller;

import com.ayit.my.shop.utils.PageInfo;
import com.ayit.my.shop.utils.persistence.BaseEntity;
import com.ayit.my.shop.utils.persistence.BaseResult;
import com.ayit.my.shop.domain.TbUser;
import com.ayit.my.shop.web.admin.abstracts.AbstractBaseController;
import com.ayit.my.shop.web.admin.service.ITbUserServicve;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController extends AbstractBaseController<ITbUserServicve, TbUser> {


    @ModelAttribute
    public TbUser getTbUser(Long id){
        System.out.println("id = " + id+"=");
        TbUser tbUser = null;
        if(id != null){
            tbUser = service.selectById(id);
        }
        else{
            tbUser = new TbUser();
        }
      return tbUser;
    }


    @Override
    @RequestMapping(value ="list",method = RequestMethod.GET)
    public String list(Model model){
        List<TbUser> tbUsers = service.selectAll();
        model.addAttribute("userlist",tbUsers);
        return "user_list";
    }

    @Override
    @RequestMapping(value = "from",method = RequestMethod.GET)
    public String from(){

        return "user_from";
    }

    @Override
    @RequestMapping(value = "save" ,method = RequestMethod.POST)
    public String list(TbUser user , Model model , RedirectAttributes redirectAttributes){
        BaseResult baseResult = service.Save(user);
        if(baseResult.getStatus() == 200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            model.addAttribute("baseResult",baseResult);
            return "redirect:/user/list";
        }else{
            model.addAttribute("baseResult",baseResult);
            return "user_from";
        }

    }





    /**
     * 删除功能
     * @param ids
     * @return
     */
    @Override
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult delete(String ids){
        BaseResult baseResult;
        if(StringUtils.isNoneBlank(ids)){
            baseResult = BaseResult.success("删除用户成功");

            String[] id = ids.split(",");

            service.deleteMulti(id);
        }
        else{
            baseResult = BaseResult.fail("删除用户失败");
        }
        return baseResult;

    }

    @Override
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<TbUser> page(HttpServletRequest request,TbUser tbUser){
        Map<String, Object> result = new HashMap<>();

        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String sytLength = request.getParameter("length");
        int draw =  strDraw == null?0:Integer.valueOf(strDraw);
        int start =  strStart == null?0:Integer.valueOf(strStart);
        int length =  sytLength == null?0:Integer.valueOf(sytLength);
        PageInfo<TbUser> tbUserPageInfo = service.queryPage(start, length, draw,tbUser);

        return tbUserPageInfo;
    }


    @Override
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(TbUser tbUser){
        return "user_detail";
    }


}
