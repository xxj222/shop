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
                            <h3 class="box-title">${tbContentCategory.id==null?'新增':'编辑'}分类</h3>
                        </div>

                        <c:if test="${baseResult != null}">

                            <div class="alert alert-${baseResult.status == 200 ? "success":"danger"} alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                    ${baseResult.message}
                            </div>
                        </c:if>

                        <form:form id="inputFrom" cssClass="form-horizontal" action="/content/category/save" method="post" modelAttribute="tbContentCategory">
                            <form:hidden path="id"/>
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="name" class="col-sm-2 control-label">父级类目</label>
                                    <div class="col-sm-10">
                                        <form:hidden path="parentCategory.id" id="parentId"/>
                                        <form:input path="parentCategory.name" cssClass="form-control"  readonly="true" placeholder="请输入父级类目"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="name" class="col-sm-2 control-label">分类名称</label>
                                    <div class="col-sm-10">
                                        <form:input path="name" cssClass="form-control required" placeholder="请输入名称"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="sortOrder" class="col-sm-2 control-label">分类排序</label>
                                    <div class="col-sm-10">
                                        <form:input path="sortOrder" cssClass="form-control required" placeholder="请输入排序"></form:input >
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






