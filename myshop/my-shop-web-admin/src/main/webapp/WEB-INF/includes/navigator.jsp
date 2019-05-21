<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- Logo -->
<a href="#" class="logo">
    <!-- mini logo for sidebar mini 50x50 pixels -->
    <span class="logo-mini"><b>商城</b></span>
    <!-- logo for regular state and mobile devices -->
    <span class="logo-lg"><b>我的商城</b></span>
</a>
<nav class="navbar navbar-static-top">
    <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
    </a>
    <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">

            <!-- User Account: style can be found in dropdown.less -->
            <li class="dropdown user user-menu">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <img src="/static/assets/img/user2-160x160.jpg" class="user-image" alt="User Image">
                    <span class="hidden-xs">${user.username}</span>
                </a>
                <ul class="dropdown-menu">
                    <!-- User image -->
                    <li class="user-header">
                        <img src="/static/assets/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                        <p>
                            xxj
                            <small><fmt:formatDate value="${user.created}" pattern="yyyy-MM-dd HH:mm:ss" ></fmt:formatDate></small>
                        </p>
                    </li>

                    <!-- Menu Footer-->
                    <li class="user-footer">
                        <div class="pull-left">
                            <a href="#" class="btn btn-default btn-flat">简况</a>
                        </div>
                        <div class="pull-right">
                            <a href="#" class="btn btn-default btn-flat">登出</a>
                        </div>
                    </li>
                </ul>
            </li>
            <%--设置图标--%>
            <li>
                <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
            </li>
        </ul>
    </div>
</nav>
