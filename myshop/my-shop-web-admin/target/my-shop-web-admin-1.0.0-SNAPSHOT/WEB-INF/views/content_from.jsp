<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <title>我的商城 | 内容管理</title>
    <jsp:include page="../includes/header.jsp"></jsp:include>
    <%--zTree--%>
    <link rel="stylesheet" href="/static/assets/plugins/jquery-ztree/css/zTreeStyle/zTreeStyle.css" >
    <%--图片上传插件 样式--%>
    <link rel="stylesheet" href="/static/assets/plugins/dropzone/min/dropzone.min.css">
    <link rel="stylesheet" href="/static/assets/plugins/dropzone/min/basic.min.css">
    <link rel="stylesheet" href="/static/assets/plugins/wangeditor/wangEditor.css">
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
                            <h3 class="box-title">${tbContent.id==null?'新增':'编辑'}内容</h3>
                        </div>

                        <c:if test="${baseResult != null}">

                            <div class="alert alert-${baseResult.status == 200 ? "success":"danger"} alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                    <%--<h4><i class="icon fa fa-ban"></i> ${baseResult.status == 200 ? "提示":"警告"}</h4>--%>
                                    ${baseResult.message}
                            </div>
                        </c:if>


                        <form:form id="inputFrom" cssClass="form-horizontal" action="/content/save" method="post" modelAttribute="tbContent">
                            <form:hidden path="id"/>
                            <div class="box-body">
                                <div class="form-group">
                                    <label  class="col-sm-2 control-label">父级类目</label>
                                    <div  class="col-sm-10">
                                        <form:hidden id="categoryId" path="tbContentCategory.id"/>
                                        <input name="name" id ="name" class = "form-control required" placeholder="请选择" readonly="true" data-toggle="modal" data-target="#modal-default" value="${tbContent.tbContentCategory.name}"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="title" class="col-sm-2 control-label">标题</label>
                                    <div  class="col-sm-10">
                                        <form:input path="title" cssClass="form-control required" placeholder="请输入标题"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="subTitle" class="col-sm-2 control-label">小标题</label>
                                    <div  class="col-sm-10">
                                        <form:input path="subTitle" cssClass="form-control required" placeholder="请输入小标题"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="titleDesc" class="col-sm-2 control-label">标题描述</label>
                                    <div  class="col-sm-10">
                                        <form:input path="titleDesc" cssClass="form-control required" placeholder="请输入标题描述"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="url" class="col-sm-2 control-label">链接</label>
                                    <div  class="col-sm-10">
                                        <form:input path="url" cssClass="form-control required" placeholder="请输入链接地址"/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="pic" class="col-sm-2 control-label">图片</label>
                                    <div  class="col-sm-10">
                                        <form:input path="pic" cssClass="form-control required" placeholder="请选择图片"/>
                                        <div id="dropz" class="dropzone"></div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="pic2" class="col-sm-2 control-label">图片</label>
                                    <div  class="col-sm-10">
                                        <form:input path="pic2" cssClass="form-control required" placeholder="请选择图片"/>
                                        <div id="dropz2" class="dropzone"></div>
                                    </div>
                                </div> <div class="form-group">
                                    <label class="col-sm-2 control-label">内容</label>
                                    <div  class="col-sm-10">
                                        <form:hidden path="content"/>
                                <div id="editor">${tbContent.content}
                                </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                                <button id ="btnSubmit" type="submit" class="btn btn-info pull-right">提交</button>
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
<script  src="/static/assets/plugins/jquery-ztree/js/jquery.ztree.core-3.5.js"></script>
<script src="/static/assets/plugins/dropzone/min/dropzone.min.js"></script>
<script src="/static/assets/plugins/wangeditor/wangEditor.js"></script>


<sys:tag_modal title="请选择"  message="<ul id='myTree' class='ztree'></ul>"/>
<script>


    $(function () {
        App.initTreeData("/content/category/data",["id"],function(nodes){
            var node = nodes[0];
            $("#categoryId").val(node.id);
            $("#name").val(node.name);
            $("#modal-default").modal("hide");
        });

        var E = window.wangEditor;
        var editor = new E('#editor');
        // 配置服务器端地址
        editor.customConfig.uploadImgServer = '/upload';
        editor.customConfig.uploadFileName = 'editorFile'
        editor.create();
        $("#btnSubmit").bind("click",function () {
            $("#content").val(editor.txt.html());

            })

    });



    // App.initDropzone({
    //
    //
    // })




    App.initDropzone({
        url:"/upload",
        id:"#dropz",
        init: function () {
            this.on("success", function (file, data) {
                $("#pic").val(data.fileName);
            });
        }
    });
    App.initDropzone({
        url:"/upload",
        id:"#dropz2",
        init: function () {
            this.on("success", function (file, data) {
                $("#pic2").val(data.fileName);
            });
        }
    });

</script>
</body>

</html>






