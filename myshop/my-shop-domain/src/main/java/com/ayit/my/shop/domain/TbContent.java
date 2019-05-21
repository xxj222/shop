package com.ayit.my.shop.domain;

import com.ayit.my.shop.utils.persistence.BaseEntity;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
public class TbContent extends BaseEntity
{



    private Long  categoryId;

    @NotBlank(message = "标题不能为空")
    private String title;
    @NotBlank(message = "小标题不能为空")
    private String subTitle;
    @NotBlank(message = "标题描述不能为空")
    private String titleDesc;
    private String url;
    private String pic;
    private String pic2;
    @NotBlank(message = "内容不能为空")
    private String content;

    @NotNull(message = "父级类目不能为空")
    private TbContentCategory tbContentCategory;


}
