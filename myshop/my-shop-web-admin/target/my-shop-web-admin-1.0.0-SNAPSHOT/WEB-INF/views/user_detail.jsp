<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

    <title>我的商城 |  用户详情</title>
    <jsp:include page="../includes/header.jsp"></jsp:include>
</head>

<body class="hold-transition skin-blue sidebar-mini">
<table class="table  table-hover">
    <tbody>
    <tr>
        <td>姓名</td>
        <td>${tbUser.username}</td>
    </tr>
    <tr>
        <td>手机号</td>
        <td>${tbUser.phone}</td>
    </tr>
    <tr>
        <td>邮箱</td>
        <td>${tbUser.email}</td>
    </tr>
    <tr>
        <td>更新时间</td>
        <td><fmt:formatDate value="${tbUser.updated}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
    </tr>

    </tbody>
</table>
<%--<sys:tag_modal/>--%>

<jsp:include page="../includes/footer.jsp"></jsp:include>


</body>

</html>