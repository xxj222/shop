package com.ayit.my.shop.domain;

import com.ayit.my.shop.utils.persistence.BaseTreeEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class TbContentCategory extends BaseTreeEntity{




    @Length(min=1,max=20,message = "分类名称需要在1-20位之间")
    private String name;
    private Integer status;

    private Integer sortOrder;



    private TbContentCategory parentCategory;

}
