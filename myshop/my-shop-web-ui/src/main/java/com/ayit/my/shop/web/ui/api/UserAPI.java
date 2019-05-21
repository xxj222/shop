package com.ayit.my.shop.web.ui.api;

import com.ayit.my.shop.utils.HttpClientUtil;
import com.ayit.my.shop.utils.MapperUtil;
import com.ayit.my.shop.web.ui.dto.TbUser;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserAPI {

    /**
     * 登录功能对接API
     * @param tbUser
     * @return
     */
    public static TbUser login(TbUser tbUser){
        TbUser user = null;
        List<BasicNameValuePair> params  = new ArrayList<>();
        params.add(new BasicNameValuePair("username",tbUser.getUsername()));
        params.add(new BasicNameValuePair(("password"),tbUser.getPassword()));

        String result = HttpClientUtil.doPost(API.User_API,params.toArray(new BasicNameValuePair[params.size()]));
        System.out.println(result);
        try {
             user = MapperUtil.json2pojoByTree(result, TbUser.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 注册功能
     * @param tbUser
     * @return
     */
    public static String  register(TbUser tbUser){
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username",tbUser.getUsername()));
        params.add(new BasicNameValuePair("password",tbUser.getPassword()));
        params.add(new BasicNameValuePair("phone",tbUser.getPhone()));
        params.add(new BasicNameValuePair("email",tbUser.getEmail()));

        String result = HttpClientUtil.doPost(API.USER_API_REGISTER, params.toArray(new BasicNameValuePair[params.size()]));

//        TbUser user = null;
//        try {
//            user = MapperUtil.json2pojo(result, TbUser.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return result;
    }
    
}
