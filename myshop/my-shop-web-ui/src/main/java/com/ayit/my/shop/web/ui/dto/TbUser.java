package com.ayit.my.shop.web.ui.dto;

import lombok.Data;

@Data
public class TbUser {
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String verificode;
    private String checkpwd;

}
