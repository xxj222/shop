<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" type="java.lang.String" required="false" description="自定义标签标题"%>
<%@ attribute name="message" type="java.lang.String" required="false" description="自定义提示信息"%>
<%--<%@ attribute name="opts" type="java.lang.String" required="false" description="操作信息"%>--%>
<%--<%@ attribute name="url" type="java.lang.String" required="false" description="进行删除时的路径信息"%>--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="modal  fade" id="modal-detail">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">${title == null ? "提示":title}</h4>
            </div>
            <div class="modal-body">
                <p id="modal-detail-body">${message}</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
