package com.ayit.my.shop.web.admin.web.controller;

import com.ayit.my.shop.domain.TbContentCategory;
import com.ayit.my.shop.utils.PageInfo;
import com.ayit.my.shop.utils.persistence.BaseEntity;
import com.ayit.my.shop.utils.persistence.BaseResult;
import com.ayit.my.shop.web.admin.abstracts.AbstractBaseTreeController;
import com.ayit.my.shop.web.admin.service.ITbContentCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/content/category")
public class ContentCategoryController extends AbstractBaseTreeController<ITbContentCategoryService,TbContentCategory> {



    @ModelAttribute
    public TbContentCategory getTbContentCategory(Long id){

        TbContentCategory tbContentCategory = null;
        if(id != null){
            tbContentCategory = service.selectById(id);
        }
        else{
            tbContentCategory = new TbContentCategory();
        }
        return tbContentCategory;
    }


    @Override
    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<TbContentCategory> targetList = new ArrayList<>();
        List<TbContentCategory> sourceList = service.selectAll();

        sort(targetList,sourceList,0L);
        for (TbContentCategory tbContentCategory : targetList) {
            System.out.println(tbContentCategory);
        }
        model.addAttribute("tbContentCategories",targetList);
        return "content_category_list";
    }


    /**
     * 根据id查所有的类目
     * @param id
     * @return
     */
    @Override
    @ResponseBody
    @RequestMapping(value = "data",method = RequestMethod.POST)
    public List<TbContentCategory> selectById(Long id){
        if(id == null){
            id = 0L;
        }
        return service.selectAllById(id);
    }

    @Override
    @RequestMapping(value="from",method = RequestMethod.GET)
    public String from(TbContentCategory tbContentCategory){
        return "category_from";
    }


    @Override
    @RequestMapping(value = "save" ,method = RequestMethod.POST)
    public String list(TbContentCategory tbContentCategory , Model model , RedirectAttributes redirectAttributes){
        BaseResult baseResult = service.Save(tbContentCategory);
        if(baseResult.getStatus() == 200){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            model.addAttribute("baseResult",baseResult);
            return "redirect:/content/category/list";
        }else{
            model.addAttribute("baseResult",baseResult);
            return "category_from";
        }

    }


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


}
