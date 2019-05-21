package com.ayit.my.shop.utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailUtils {

    public static void main(String[] args) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.qq.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("1031586735@qq.com", "omgiihgowsbpbcga"));
        email.setSSLOnConnect(true);
        email.setFrom("1031586735@qq.com");
        email.setSubject("测试");
        email.setMsg("This is a test mail ... :-)");
        email.addTo("1787449575@qq.com");
        email.send();
    }


}
