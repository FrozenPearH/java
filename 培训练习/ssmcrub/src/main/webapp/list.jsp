<%--
  Created by IntelliJ IDEA.
  User: 25719
  Date: 2019/7/16
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("App_Path",request.getContextPath());
%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>员工列表</title>
    <link rel="stylesheet" href="${App_Path}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <script  src="${App_Path}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${App_Path}/static/js/jquery-3.4.1/jquery-3.4.1/jquery-3.4.1.js"></script>
</head>
<body>
    <div class="container">
        <%--标题栏--%>
        <div class="row">
            <div class="col-md-12">
                <h1>人员管理</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 col-md-offset-8">
                <button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-pencil" aria-hidden="false"></span>新增</button>
                <button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="false"></span>删除</button>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <table class="table table-hover">
                    <tr>
                    <th>工号</th><th>姓名</th><th>性别</th><th>邮箱</th><th>部门</th><th>操作</th>
                </tr>
                    <c:forEach items="${pageInfo.list}" var="emp">
                    <tr>
                        <th>${emp.empId}</th><th>${emp.empName}</th><th>${emp.gender=="m"?"男":"女"}</th><th>${emp.email}</th><th>${emp.department.deptName}</th><th>
                            <button type="button" class="btn btn-primary  btn-sm">
                                <span class="glyphicon glyphicon-pencil " aria-hidden="false"></span>
                                编辑
                            </button>
                            <button type="button" class="btn btn-danger  btn-sm">
                                <span class="glyphicon glyphicon-trashm" aria-hidden="false"></span>
                                删除
                            </button>
                        </th>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div class="row">
            <%--分页的文字信息--%>
            <div class="col-md-6">
                当前为第${pageInfo.pageNum}页，一共${pageInfo.pages}页，当前${pageInfo.size}条数据，一共${pageInfo.total}条数据
            </div>
            <%--分页条--%>
            <div class="col-md-6">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li><a href="/emps?pn=1">首页</a></li>
                        <c:if test="${pageInfo.pageNum==1}">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum!=1}">
                            <li>
                                <a href="/emps?pn=${pageInfo.hasPreviousPage?(pageInfo.pageNum-1):pageInfo.pageNum}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
                            <c:if test="${page_num==pageInfo.pageNum}">
                                    <li class="active"><a href="#">${page_num}</a></li>
                            </c:if>
                            <c:if test="${page_num!=pageInfo.pageNum}">
                                <li ><a href="/emps?pn=${page_num}">${page_num}</a></li>
                            </c:if>
                        </c:forEach>
                        <c:if test="${pageInfo.pageNum==pageInfo.pages}">
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum!=pageInfo.pages}">
                            <li>
                                <a href="/emps?pn=${pageInfo.hasNextPage?(pageInfo.pageNum+1):pageInfo.pageNum}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <li><a href="/emps?pn=${pageInfo.pages}">尾页</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</body>
</html>
