<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- jQuery 3 -->
<script src="/static/assets/bower_components/jquery/dist/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="/static/assets/bower_components/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.7 -->
<script src="/static/assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- DataTables -->
<script src="/static/assets/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="/static/assets/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="/static/assets/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.js"></script>

<!-- Slimscroll -->
<script src="/static/assets/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="/static/assets/bower_components/fastclick/lib/fastclick.js"></script>

<script src="/static/assets/plugins/iCheck/icheck.js"></script>
<!-- AdminLTE App -->
<script src="/static/assets/js/adminlte.min.js"></script>

<script src="/static/assets/plugins/treeTable/jquery.treeTable.js"></script>


<%--自定义规则验证--%>
<script src="/static/assets/js/jquery.validate.js"></script>

<script src="/static/assets/js/additional-methods.js"></script>

<script src="/static/assets/js/localization/messages_zh.js"></script>



<%--引入自定义的js--%>
<script src="/static/assets/App/validate.js" ></script>
<script src="/static/assets/App/app.js"></script>
<script src="/static/assets/App/datetime.js"></script>