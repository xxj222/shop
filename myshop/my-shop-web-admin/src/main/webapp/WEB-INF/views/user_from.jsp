<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <jsp:include page="../includes/header.jsp"></jsp:include>
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <header class="main-header">

        <jsp:include page="../includes/navigator.jsp"></jsp:include>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
        <jsp:include page="../includes/menu.jsp"></jsp:include>
    </aside>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->

        <section class="content-header">

            <h1>
                用户管理
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>
        <section class="content">
            <div class="row">

                <div class="col-xs-12">




                    <!-- Horizontal Form -->
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">${tbUser.id==null?'新增':'编辑'}用户</h3>
                        </div>

                        <c:if test="${baseResult != null}">

                            <div class="alert alert-${baseResult.status == 200 ? "success":"danger"} alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                    <%--<h4><i class="icon fa fa-ban"></i> ${baseResult.status == 200 ? "提示":"警告"}</h4>--%>
                                    ${baseResult.message}
                            </div>
                        </c:if>

                        <form:form id="inputFrom" cssClass="form-horizontal" action="/user/save" method="post" modelAttribute="tbUser">
                            <form:hidden path="id"/>
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="email" class="col-sm-2 control-label">邮箱</label>

                                    <div class="col-sm-10">
                                        <form:input path="email" cssClass="form-control required email" placeholder="请输入邮箱"></form:input >

                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-sm-2 control-label">密码</label>

                                    <div class="col-sm-10">
                                        <form:input path="password" cssClass="form-control required" placeholder="请输入密码"></form:input >

                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="username" class="col-sm-2 control-label">姓名</label>

                                    <div class="col-sm-10">
                                        <form:input path="username" cssClass="form-control required" placeholder="请输入姓名"></form:input >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="phone" class="col-sm-2 control-label">手机号</label>

                                    <div class="col-sm-10">
                                        <form:input path="phone" cssClass="form-control required mobile" placeholder="请输入手机号"></form:input >
                                    </div>
                                </div>

                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                                <button type="submit" class="btn btn-info pull-right">提交</button>
                            </div>

                        </form:form>

                    </div>

                </div>
            </div>


        </section>


    </div>

    <!-- /.content-wrapper -->
    <%--版权信息--%>
    <jsp:include page="../includes/copyright.jsp"></jsp:include>
</div>
<jsp:include page="../includes/footer.jsp"></jsp:include>

</body>
</html>






