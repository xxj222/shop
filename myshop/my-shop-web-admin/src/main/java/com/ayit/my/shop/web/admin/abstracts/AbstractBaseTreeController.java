package com.ayit.my.shop.web.admin.abstracts;

import com.ayit.my.shop.utils.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public abstract  class AbstractBaseTreeController<S extends BaseTreeService,T extends BaseTreeEntity> {

    @Autowired
    protected S service;

    public abstract String list(Model model);

    public abstract List<T> selectById(Long id);
    public abstract String from(T entity);

    public abstract String list(T entity , Model model , RedirectAttributes redirectAttributes);
    public abstract BaseResult delete(String ids);

    /**
     *对查询出来的数据进行排序
     * @param targetList
     * @param sourceList
     * @param parentId
     */
    public  void sort(List<T> targetList,List<T> sourceList,Long parentId) {
        for (T tbContentCategory : sourceList) {

            if (tbContentCategory.getParentId().equals(parentId)) {
                targetList.add(tbContentCategory);
//                判断有没有子节点，如果有则继续追加
                if (tbContentCategory.isParent()) {

                    for (T contentCategory : sourceList) {

                        if (contentCategory.getParentId().equals(tbContentCategory.getId())) {
                            sort(targetList,sourceList, tbContentCategory.getId());
                            break;
                        }

                    }
                }
            }

        }
    }


}
