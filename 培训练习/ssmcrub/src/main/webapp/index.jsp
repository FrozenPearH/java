<%--
  Created by IntelliJ IDEA.
  User: 25720
  Date: 2019/7/17
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
 pageContext.setAttribute("app_path",request.getContextPath());
%>
<html>
<head>
    <title>Title</title>
    <!-- 引入jquery -->
    <link href="${app_path}/static/bootstrap-3.3.7-dist/CSS/bootstrap.min.css" rel="stylesheet">
    <script  src="${app_path}/static/js/jquery-3.4.1/jquery-3.4.1/jquery-3.4.1.js" type="text/javascript"></script>
    <!-- 引入样式 -->

    <script src="${app_path}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<button type="button" class="btn btn-danger">a</button>

</body>
</html>
