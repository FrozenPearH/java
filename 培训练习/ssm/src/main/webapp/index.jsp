<%--
  Created by IntelliJ IDEA.
  User: 25720
  Date: 2019/7/18
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>员工列表</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.4.1/jquery-3.4.1/jquery-3.4.1.min.js"></script>
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

</head>
<body>
<!-- 员工添加的模态框 -->
<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">员工添加</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <input type="text" name="empName" class="form-control" id="empName_add_input" placeholder="empName">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="text" name="email" class="form-control" id="email_add_input" placeholder="email@hand.com">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1_add_input" value="M" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2_add_input" value="F"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">
                            <%--部门提交时提交部门id--%>
                            <select class="form-control" name="dId" id="dept_add_select">

                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>
<%--显示界面--%>
<div class="container">
    <%--标题--%>
    <div class="row"></div>
    <div class="col-md-12">
        <h1>SSM-CRUD</h1>
    </div>
    <%--按钮--%>
    <div class="row">
        <div class="col-md-4 col-md-offset-8">
            <button type="button" class="btn btn-primary" id="emp_add_modal_btn">新增</button>
            <button type="button" class="btn btn-danger">删除</button>
        </div>
    </div>
    <%--显示表格数据--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="emps_table">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>empName</th>
                        <th>gender</th>
                        <th>email</th>
                        <th>deptName</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>

                </tbody>


            </table>
        </div>
    </div>
    <%--显示分页信息--%>
    <div class="row">
        <%--分页信息--%>
        <div class="col-md-6" id="page_info_area">

        </div>
        <%--分页条--%>
        <div class="col-md-6" id="page_nav_area">

        </div>
    </div>
</div>
<script type="text/javascript">

    var totalRecore;
    <%--1、页面加载完成以后，直接发送一个ajax请求，要到分页数据--%>
    $(function () {
        //去首页
        to_page(1);
    });
    function to_page(pn) {
        $.ajax({
            url:"${APP_PATH}/emps",
            data:"pn="+pn,
            type:"GET",
            success:function(result) {
                // console.log(result);
                //    1、在页面解析并显示员工数据
                build_emps_table(result);
                //    2、解析并显示分页信息
                build_page_info(result);
                //3、解析显示分页条数据
                build_page_nav(result);

            }
        });
    }
    function build_emps_table(result) {
        //清空table表格
        $("#emps_table tbody").empty();
        //生成表格
        var emps = result.extend.pageInfo.list;
        $.each(emps,function (index,item) {
            // alert(item.empName);
            var empIdTd = $("<td></td>").append(item.empId);
            var empNameTd = $("<td></td>").append(item.empName);
            var genderTd = $("<td></td>").append(item.gender=="M"?"男":"女");
            var emailTd = $("<td></td>").append(item.email);
            var departmentTd = $("<td></td>").append(item.department.deptName);
            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
            var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
            var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn)
            //因为append方法返回执行完成后返回的还是原来的元素
            $("<tr></tr>").append(empIdTd)
                .append(empNameTd)
                .append(genderTd)
                .append(emailTd)
                .append(departmentTd)
                .append(btnTd)
                .appendTo("#emps_table tbody");
        });

    }
    //解析显示分页信息
    function build_page_info(result) {
        //清空分页信息
        $("#page_info_area").empty();
        //生成分页信息
        $("#page_info_area").append("当前第"+result.extend.pageInfo.pageNum+"页,总"+result.extend.pageInfo.pages+"页,总共"+result.extend.pageInfo.total+"条记录");
        totalRecore = result.extend.pageInfo.total;
    }
    //解析显示分页条
    function build_page_nav(result){
        $("#page_nav_area").empty();
        var ul = $("<ul></ul>").addClass("pagination");
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if (result.extend.pageInfo.hasPreviousPage==false){
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        }else{
            firstPageLi.click(function () {
                to_page(1);
            });
            prePageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum-1);
            });
        }

        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
        if (result.extend.pageInfo.hasNextPage==false){
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        }else{
            nextPageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum+1);
            });
            lastPageLi.click(function () {
                to_page(result.extend.pageInfo.pages);
            });
        }

        ul.append(firstPageLi).append(prePageLi);
        $.each(result.extend.pageInfo.navigatepageNums,function (index,item) {
            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if (result.extend.pageInfo.pageNum==item){
                numLi.addClass("active");
            }
            numLi.click(function () {
                to_page(item);
            })
            ul.append(numLi);
        })
        ul.append(nextPageLi).append(lastPageLi);
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
    }


    //点击新增，弹出模块框
    $("#emp_add_modal_btn").click(function () {
        //发出ajax请求，查出部门信息，显示在下拉列表中
        getDepts();
        $("#empAddModal").modal({
            backdrop:"static"
        });
    });
//    查出部门信息，显示在下拉列表中
    function getDepts() {
        $.ajax({
            url:"${APP_PATH}/depts",
            type:"GET",
            success:function (result) {
                // console.log(result);
            //    {"code":100,"msg":"处理成功！",
                //    "extend":{"depts":[{"deptId":1,"deptName":"开发部"},
                //    {"deptId":2,"deptName":"测试"}]}}
            //    显示部门信息在下拉列表中
                $("#dept_add_select").empty();
                $.each(result.extend.depts,function () {

                    var optionEle = $("<option></option>").append(this.deptName).attr("value",this.deptId);
                    optionEle.appendTo("#dept_add_select");
                });
            }
        });
    }
    //校验表单数据方法
    function validate_add_form(){
    //    拿到校验数据
    //    校验用户名
        var empName = $("#empName_add_input").val();
        var regName = /^[\u4E00-\u9FA5A-Za-z0-9_-]{2,16}$/;
        if(!regName.test(empName)){
            // alert("不符合用户名输入规则")

            // $("#empName_add_input").parent().addClass("has-error");
            // $("#empName_add_input").next("span").text("不符合用户名输入规则");
            show_validate_msg("#empName_add_input","error","不符合用户名输入规则")
            return false;
        }else {
            // $("#empName_add_input").parent().addClass("has-success");
            // $("#empName_add_input").next("span").text("符合用户名输入规则");
            show_validate_msg("#empName_add_input","success","")
        };
    //    校验邮箱
        var email = $("#email_add_input").val();
        var regEmail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        if (!regEmail.test(email)){
            // alert("不符合邮箱输入规则")
            // $("#email_add_input").parent().addClass("has-error");
            // $("#email_add_input").next("span").text("不符合邮箱输入规则");
            show_validate_msg("#email_add_input","error","不符合邮箱输入规则")
            return false;
        }else {
            // $("#email_add_input").parent().addClass("has-success");
            // $("#email_add_input").next("span").text("符合邮箱输入规则");
            show_validate_msg("#email_add_input","success","")
        }
        return true;
    };

    //抽出校验方法
    function show_validate_msg(ele,status,msg){
    //    首先清除当前元素的状态信息，避免重复插入
        $(ele).parent().removeClass("has-success has-error");
        $(ele).next("span").text("");
        if (status=="success"){
            $(ele).parent().addClass("has-success");
            $(ele).next("span").text(msg);
        }else if (status=="error") {
            $(ele).parent().addClass("has-error");
            $(ele).next("span").text(msg);
        }
    }


    $("#emp_save_btn").click(function () {
    //    1、将模态框内填写的数据提交给服务器进行保存
    //      a、保存前先进行数据校验
        if (!validate_add_form()){
            return false;
        } ;
    //    2、发生ajax请求保存员工
        $.ajax({
            url:"${APP_PATH}/emp",
            type:"POST",
            data:$("#empAddModal form").serialize(),
            success:function (result) {
                // alert(result.msg);
            //    保存员工成功后
            //    1、关闭模态框
                $("#empAddModal").modal('hide');
            //    2、来到最后一页显示数据
            //    发送ajax请求显示最后一页数据，分页会自动获取最大的页码
            //    将总记录条数当作页码，超过分页最大值会自动平衡调整
                to_page(totalRecore);
            }
        });
    });
</script>

</body>
</html>
