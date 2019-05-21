<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--引入自定义标签--%>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>


<jsp:useBean id="tbUser" class="com.ayit.my.shop.domain.TbUser" scope="request"></jsp:useBean>
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
                <li><a href="#"><i class="fa fa-dashboard"></i> 用户管理</a></li>
                <li class="active">控制面板</li>
            </ol>

            <!-- /.row -->
            <div class="row">
                <div class="col-xs-12">

                    <div class="box box-info box-info-search" style="display: none">
                        <div class="box-header">
                            <h3 class="box-title">高级搜索</h3>
                        </div>

                            <div class="box-body ">
                                <div class="row form-horizontal">
                                    <div class="col-xs-12 col-sm-3">
                                        <div class="form-group">

                                            <label for="username" class="col-sm-4 control-label">姓名</label>
                                            <div class="col-sm-8">
                                                <input id="username" class="form-control" placeholder="请输入姓名">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-3 col-sm-3">
                                        <div class="form-group">

                                            <label for="phone" class="col-sm-4 control-label">手机</label>
                                            <div class="col-sm-8">
                                                <input id="phone" class="form-control" placeholder="请输入手机号">

                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-xs-3 col-sm-3">
                                        <div class="form-group">

                                            <label for="email" class="col-sm-4 control-label">邮箱</label>
                                            <div class="col-sm-8">
                                                <input id="email" class="form-control" placeholder="请输入邮箱">
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="row">
                                <button type="button" onclick="search();" class="btn btn-info" >搜索</button>
                            </div>



                    </div>
                    <c:if test="${baseResult != null}">

                        <div class="alert alert-${baseResult.status == 200 ? "success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                <%--<h4><i class="icon fa fa-ban"></i> ${baseResult.status == 200 ? "提示":"警告"}</h4>--%>
                                ${baseResult.message}
                        </div>
                    </c:if>

                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">用户列表</h3>


                    </div>

                <div class="box-body">
                    <div style="padding-left: 17px;padding-top: 5px;" class="row ">
                        <!-- Check all button -->

                        <a href="/user/from" type="button" class="btn btn-primary"><i class=" fa fa-plus"></i>新增</a>&nbsp&nbsp
                        <a type="button" class="btn btn-danger" onclick="App.deleteMulti('/user/delete')"><i class=" fa fa-trash"></i>批量删除</a>&nbsp&nbsp
                        <a type="button" class="btn btn-info"><i class=" fa fa-download"></i>导入</a>&nbsp&nbsp
                        <a type="button" class="btn btn-info"><i class=" fa fa-upload"></i>导出</a>&nbsp&nbsp
                        <a type="button" class="btn btn-info" onclick="$('.box-info-search').css('display') == 'none'?$('.box-info-search').show('fast'):$('.box-info-search').hide('fast')" ><i class=" fa fa-search" ></i>搜索</a>
                    </div>

                </div>

                    <!-- /.box-header -->
                    <div class="box-body table-responsive">
                        <table id="dataTable" class="table  table-responsive  table-bordered table-striped  table-hover">
                            <thead >

                            <tr>
                                <th><input type="checkbox" class="minimal check_master"></th>
                                <th>ID</th>
                                <th>姓名</th>
                                <th>手机号</th>
                                <th>邮箱</th>
                                <th>更新时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>

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

<sys:tag_modal />
<sys:modal_detail/>

<script>
    let initDatatables;


    $(function(){

        let param =  [
            {data:function(row, type, val, meta){
                    return '<input id="'+row.id+'" type="checkbox" class="minimal">';
                }},
            { data: "id"},
            { data: "username"},
            { data: 'phone' },
            { data: 'email' },
            {data:function(row, type, val, meta){
                    return DateTime.format(row.updated,"yyyy-MM-dd hh:mm:ss");
                }},
            {data:function(row, type, val, meta){
                    // console.log(row);
                    var url = "/user/detail?id="+row.id;
                    var url2 = "/user/delete";
                    return '<button onclick="App.initShowDetail(\''+url+'\')" type="button" class="btn btn-default"><i class=" fa fa-search"></i>查看</button>' +
                        '<a href="/user/from?id='+row.id+'" type="button" class="btn btn-primary"><i class=" fa fa-edit"></i>编辑</a>' +
                        '<a type="button" onclick="App.deleteMulti(\''+url2+'\')" class="btn btn-danger" ><i class=" fa fa-trash"></i>删除</a>';
                }},
        ];

        initDatatables = App.initDatatables("/user/page",param);

    })


    function search(){

        let username = $("#username").val();
        let phone = $("#phone").val();
        let email = $("#email").val();

        let param = {
            "username":username,
            "email":email,
            "phone":phone
        };


        initDatatables.settings()[0].ajax.data = param;
        initDatatables.ajax.reload();
    }



</script>
</body>
</html>