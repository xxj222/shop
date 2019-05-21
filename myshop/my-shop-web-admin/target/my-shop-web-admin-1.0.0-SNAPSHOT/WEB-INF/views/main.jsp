<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <%--<jsp:include page="../includes/header.jsp"/>--%>
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
                控制面板

            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>
    </div>

    <!-- /.content-wrapper -->
<%--版权信息--%>
<jsp:include page="../includes/copyright.jsp"></jsp:include>
</div>
<jsp:include page="../includes/footer.jsp"></jsp:include>

</body>
</html>