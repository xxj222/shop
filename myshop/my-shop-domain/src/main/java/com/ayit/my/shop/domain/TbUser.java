package com.ayit.my.shop.domain;

import com.ayit.my.shop.utils.RegexpUtils;
import com.ayit.my.shop.utils.persistence.BaseEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;

@Data
public class TbUser  extends BaseEntity {

    @Length(min = 6,max = 20,message = "请输入长度在6-20之间的姓名")
    private String username;
    @Length(min = 6,max = 20,message = "请输入长度在6-20之间的密码")
    private String password;
    @Pattern(regexp=RegexpUtils.PHONE ,message = "手机号格式不正确")
    private String phone;
    @Pattern(regexp=RegexpUtils.EMAIL,message = "邮箱格式不正确")
    private String email;






}
