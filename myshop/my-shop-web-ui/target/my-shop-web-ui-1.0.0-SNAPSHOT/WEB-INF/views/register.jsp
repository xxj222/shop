<%--
  Created by IntelliJ IDEA.
  User: spring
  Date: 2019-05-17
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MyShop——个人注册</title>
    <link rel="stylesheet" type="text/css" href="/static/css/index.css">
    <link rel="stylesheet" type="text/css" href="/static/css/ziy.css">
</head>
<body>
<!--dengl-->
<div class="yiny">
    <div class="beij_center">
        <div class="dengl_logo">
            <img src="/static/images/logo_1.png">
            <h1>欢迎注册</h1>
        </div>
    </div>
</div>
<div class="beij_center">
    <div class="ger_zhuc_beij">
        <div class="ger_zhuc_biaot">
            <ul>
                <li class="ger_border_color"><a href="zhuc.html">个人注册</a></li>
                <i>丨</i>
                <li><a href="shenq_ruz.html">申请入驻</a></li>
                <p>我已经注册，现在就<a class="ftx-05 ml10" href="/login">登录</a></p>
            </ul>
        </div>
        <div class="zhuc_biaod">
            <c:if test="${baseResult != null}">
                <div class="red">${baseResult.message}</div>
            </c:if>
            <form action="/register" method="post">

                <div class="reg-items" >
              	<span class="reg-label">
                	<label for="username">用户名：</label>
              	</span>
                    <input  id="username"  name="username" class="i-text" type="text">
                    <!--备注————display使用 inline-block-->
                    <div class="msg-box">
                        <div class="msg-box" style="display: none;">
                            <div class="msg-weak" style="display: inline-block;"> <i></i>
                                <div class="msg-cont">4-20个字符，支持汉字、字母、数字及“-”、“_”组合</div>
                            </div>
                        </div>
                        <div class="msg-weak err-tips"  style="display: inline-block;"><div>请输入用户名</div></div>
                    </div>
                    <span class="suc-icon"></span>
                </div>
                <div class="reg-items" >
              	<span class="reg-label">
                	<label for="password">设置密码：</label>
              	</span>
                    <input id="password" name="password"  class="i-text" type="password">
                    <!--备注————display使用 inline-block-->
                    <div class="msg-box">
                        <div class="msg-box" style="display: none;">
                            <div class="msg-weak" style="display: inline-block;"> <i></i>
                                <div class="msg-cont">键盘大写锁定已打开，请注意大小写!</div>
                            </div>
                        </div>
                        <div class="msg-weak err-tips"  style="display:none;"><div>请输入密码</div></div>
                    </div>
                </div>
                <div class="reg-items" >
              	<span class="reg-label">
                	<label for="checkpwd">确认密码：</label>
              	</span>
                    <input id="checkpwd" name="checkpwd" class="i-text" type="password" >
                    <!--备注————display使用 inline-block-->
                    <div class="msg-box">
                        <div class="msg-weak err-tips"  style="display: none;"><div>密码不一样</div></div>
                    </div>
                </div>
                <div class="reg-items" >
              	<span class="reg-label">
                	<label for="phone">手机号码：</label>
              	</span>
                    <input  id="phone"  name="phone" class="i-text" type="text">
                    <!--备注————display使用 inline-block-->
                    <div class="msg-box">
                        <div class="msg-weak err-tips"  style="display:none;"><div>手机号不能为空</div></div>
                    </div>
                </div>

                <div class="reg-items" >
              	<span class="reg-label">
                	<label for="email">邮箱：</label>
              	</span>
                    <input  id="email"  name="email" class="i-text" type="text">
                    <!--备注————display使用 inline-block-->
                    <div class="msg-box">
                        <div class="msg-weak err-tips"  style="display:none;"><div>手机号不能为空</div></div>
                    </div>
                </div>

                <div class="reg-items" >
                    <input class="reg-btn" value="立即注册" type="submit"/>

                </div>


            </form>
        </div>
        <div class="xiaogg">
            <img src="/static/images/cdsgfd.jpg">
        </div>
    </div>
</div>


<div class="jianj_dib jianj_dib_1">
    <div class="beia_hao">
        <p>京ICP备：123456789号  </p>
        <p class="gonga_bei">京公网安备：123456789号</p>
    </div>
</div>
</body>
</html>
