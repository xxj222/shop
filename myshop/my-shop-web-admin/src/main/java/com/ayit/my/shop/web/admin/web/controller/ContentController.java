package com.ayit.my.shop.web.admin.web.controller;

import com.ayit.my.shop.utils.PageInfo;
import com.ayit.my.shop.utils.persistence.BaseResult;
import com.ayit.my.shop.domain.TbContent;
import com.ayit.my.shop.web.admin.abstracts.AbstractBaseController;
import com.ayit.my.shop.web.admin.service.ITbContentService;
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
@RequestMapping(value = "content")
public class ContentController extends AbstractBaseController<ITbContentService,TbContent> {




    @ModelAttribute
    public TbContent getTbContent(Long id){

        TbContent tbContent = null;
        if(id != null){
            tbContent = service.selectById(id);
        }
        else{
            tbContent = new TbContent();
        }
        return tbContent;
    }

    @Override
    @RequestMapping(value ="list",method = RequestMethod.GET)
    public String list(Model model){
        List<TbContent> tbContents = service.selectAll();
        model.addAttribute("contentlist",tbContents);
        return "content_list";
    }
    @Override
    @RequestMapping(value = "from",method = RequestMethod.GET)
    public String from(){

        return "content_from";
    }
    @Override
    @RequestMapping(value = "save" ,method = RequestMethod.POST)
    public String list(TbContent tbContent , Model model , RedirectAttributes redirectAttributes){
        BaseResult baseResult = service.Save(tbContent);
        if(baseResult.getStatus() == 200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            model.addAttribute("baseResult",baseResult);
            return "redirect:/content/list";
        }else{
            model.addAttribute("baseResult",baseResult);
            return "content_from";
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
            baseResult = BaseResult.success("删除内容成功");

            String[] id = ids.split(",");

            service.deleteMulti(id);
        }
        else{
            baseResult = BaseResult.fail("删除内容失败");
        }
        return baseResult;

    }
    @Override
    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public PageInfo<TbContent> page(HttpServletRequest request, TbContent tbContent){
        Map<String, Object> result = new HashMap<>();

        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String sytLength = request.getParameter("length");
        int draw =  strDraw == null?0:Integer.valueOf(strDraw);
        int start =  strStart == null?0:Integer.valueOf(strStart);
        int length =  sytLength == null?0:Integer.valueOf(sytLength);
        PageInfo<TbContent> tbUserPageInfo = service.queryPage(start, length, draw,tbContent);

        return tbUserPageInfo;
    }

    @Override
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(TbContent tbContent){
        return "content_detail";
    }

}
