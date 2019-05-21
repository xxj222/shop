
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--引入自定义标签--%>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>


<jsp:useBean id="tbUser" class="com.ayit.my.shop.domain.TbUser" scope="request"></jsp:useBean>
<html>
<head>
    <title>我的商城 | 内容管理</title>
    <jsp:include page="../includes/header.jsp"></jsp:include>
<link rel="stylesheet" href="/static/assets/plugins/treeTable/themes/vsStyle/treeTable.css">
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
                内容管理

            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i>内容管理</a></li>
                <li class="active">控制面板</li>
            </ol>

            <!-- /.row -->
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult != null}">

                        <div class="alert alert-${baseResult.status == 200 ? "success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                <%--<h4><i class="icon fa fa-ban"></i> ${baseResult.status == 200 ? "提示":"警告"}</h4>--%>
                                ${baseResult.message}
                        </div>
                    </c:if>

                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">内容列表</h3>


                        </div>

                        <div class="box-body">
                            <div style="padding-left: 17px;padding-top: 5px;" class="row ">
                                <!-- Check all button -->

                                <a href="/content/category/from" type="button" class="btn btn-primary"><i class=" fa fa-plus"></i>新增</a>&nbsp&nbsp
                                <a type="button" onclick="App.deleteMulti('/content/category/delete')" class="btn btn-danger" ><i class=" fa fa-trash"></i>批量删除</a>&nbsp&nbsp
                                <a type="button" class="btn btn-info"><i class=" fa fa-download"></i>导入</a>&nbsp&nbsp
                                <a type="button" class="btn btn-info"><i class=" fa fa-upload"></i>导出</a>&nbsp&nbsp
                            </div>

                        </div>

                        <!-- /.box-header -->
                        <div class="box-body table-responsive">
                            <table id="categoryTreeTable" class="table  table-responsive  table-bordered table-striped  table-hover">
                                <thead style="position: center">
                                    <tr>
                                        <th><input type="checkbox" class="minimal check_master"></th>
                                        <th>ID</th>
                                        <th>名称</th>
                                        <th>排序</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${tbContentCategories}" var="contentCategory" >

                                        <tr id="${contentCategory.id}" pId = "${contentCategory.parentId}">
                                            <td> <input id="${contentCategory.id}" type="checkbox" class="minimal"></td>
                                            <td>${contentCategory.id}</td>
                                            <td>${contentCategory.name}</td>
                                            <td>${contentCategory.sortOrder}</td>
                                            <td><a href='/content/category/from?id=${contentCategory.id}' type="button" class="btn btn-primary"><i class=" fa fa-edit"></i>编辑</a>
                                                <a  type="button" onclick="App.deleteMulti('/content/category/delete')" class="btn btn-danger"><i class=" fa fa-trash-o"></i>删除</a>
                                                <a href="/content/category/from?parentCategory.id=${contentCategory.id}&parentCategory.name=${contentCategory.name}" type="button" class="btn btn-default"><i class=" fa fa-plus"></i>新增下级菜单</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>

    <!-- /.content-wrapper -->
    <%--版权信息--%>
    <jsp:include page="../includes/copyright.jsp"></jsp:include>
</div>




<jsp:include page="../includes/footer.jsp"></jsp:include>
<script src="/static/assets/plugins/treeTable/jquery.treeTable.js"></script>

<sys:tag_modal />


<script>
    $(function(){
        $('#categoryTreeTable').treeTable({
            column:1,
            expandLevel:2
        });
    });

</script>
</body>
</html>