<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>物料管理</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.4.1/jquery-3.4.1/jquery-3.4.1.min.js"></script>
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="${APP_PATH}/static/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
    <link rel="stylesheet" href="${App_Path}/static/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.css">

</head>
<body style="background-color: #fffef9">
<%--新增模态框--%>
<div class="modal fade" id="itemAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">新增物料</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">物料描述</label>
                        <div class="col-sm-10">
                            <input type="text" name="itemDescription" class="form-control" id="itemDescription_add_input" placeholder="">
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">物料单位</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="itemUom" id="itemUom_add_select">

                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="startDatepicker" class="col-sm-2 control-label"> 有效期从</label>
                        <div class="col-sm-4">
                            <input id="startDatepicker" type="datetime" class="form-control" autocomplete="off" name = "startActiveDate">
                        </div>
                    </div>
                    <div class="form-group">
                    <label for="endDatepicker" class="col-sm-2 control-label"> 有效期至</label>
                        <div class="col-sm-4">
                            <input id="endDatepicker" type="datetime" class="form-control" autocomplete="off" name = "endActiveDate">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">是否启用</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="enabledFlag" id="enabledFlag1_add_input" value="1" checked="checked"> 是
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="enabledFlag" id="enabledFlag2_add_input" value="0"> 否
                            </label>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="item_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>

<%--修改模态框--%>
<div class="modal fade" id="itemUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" >修改物料信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">物料编码</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="itemCode_update_static"></p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">物料描述</label>
                        <div class="col-sm-10">
                            <input type="text" name="itemDescription" class="form-control" id="itemDescription_update_input" >
                            <span class="help-block"></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">物料单位</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="itemUom" id="itemUom_update_select">

                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="updateStartDatepicker" class="col-sm-2 control-label"> 有效期从</label>
                        <div class="col-sm-4">
                            <input id="updateStartDatepicker" type="datetime" class="form-control" autocomplete="off" name = "startActiveDate">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="updateEndDatepicker" class="col-sm-2 control-label"> 有效期至</label>
                        <div class="col-sm-4">
                            <input id="updateEndDatepicker" type="datetime" class="form-control" autocomplete="off" name = "endActiveDate">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">是否启用</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="enabledFlag" id="enabledFlag1_update_input" value="1" checked="checked"> 是
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="enabledFlag" id="enabledFlag2_update_input" value="0"> 否
                            </label>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="item_update_btn">修改</button>
            </div>
        </div>
    </div>
</div>

<%--显示界面--%>
<div class="container" >
    <%--头--%>
    <div class="row" style="border-bottom: 1px #5e5e5e solid">
        <%--标题--%>
        <div class="col-md-3" >
            <h1>物料管理</h1>
        </div>
        <%--按钮--%>
        <div class="col-md-3 col-md-offset-6" style="top:30px;left: 6px">
            <button type="button" class="btn btn-primary" id="item_add_modal_btn">新建</button>
            <button type="button" class="btn btn-danger" id="item_delete_all_btn">批量删除</button>
        </div>
    </div>
    <%--查询--%>
    <div class="row" style="border-bottom: 1px #5e5e5e solid;" id="selectItem">
        <form class="form-horizontal ">
            <div class="form-group" style="margin-top: 5px;">
                <label for="itemSelectCode" class="col-sm-1 control-label">物料编码</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" name="itemCode" id="itemSelectCode" >
                </div>
                <label for="iteSelectDescription" class="col-sm-1 control-label">物料描述</label>
                <div class="col-sm-2">
                    <input type="text" class="form-control" name="iteDescription" id="iteSelectDescription" >
                </div>
                <label for="itemSelectUom" class="col-sm-1 control-label">物料单位</label>
                <div class="col-sm-2">
                    <select class="form-control" name="itemUom" id="itemSelectUom">
                        <option value="米">米</option>
                        <option value="平方米">平方米</option>
                        <option value="立方米">立方米</option>
                        <option value="千克">千克</option>
                        <option value="个">个</option>
                        <option value="其他">其他</option>
                    </select>
                </div>
                <div class="col-sm-3">
                    <button id="search" type="button" class="btn btn-primary  " style="margin-right: 1px">查询</button>
                    <button id="reset" type="reset" class="btn btn-default " id="reset">重置</button>
                </div>
            </div>
            <div class="form-group">
                <label for="selectStartActiveDate" class="col-sm-1 control-label">生效时间从</label>
                <div class="col-sm-2">
                    <input id="selectStartActiveDate" type="datetime" class="form-control" autocomplete="off" name = "startActiveDate">
                </div>
                <label for="selectEndActiveDate" class="col-sm-1 control-label">生效时间到</label>
                <div class="col-sm-2">
                    <input id="selectEndActiveDate" type="datetime" class="form-control" autocomplete="off" name = "endActiveDate">
                </div>
                <label for="selectEnabledFlag" class="col-sm-1 control-label">是否启用</label>
                <div class="col-sm-2">
                    <select class="form-control" name="enabledFlag" id="selectEnabledFlag">
                        <option value="1">是</option>
                        <option value="0">否</option>

                    </select>
                </div>

            </div>
        </form>

    </div>
    <%--表格--%>
    <div class="row">
        <div class="col-md-12">
            <table class="table table-hover" id="item_table">
                <thead>
                <tr>
                    <th>
                        <input type="checkbox" id="check_all"/>
                    </th>
                    <th style='text-align: center'>物料编码</th>
                    <th style='text-align: center'>物料描述</th>
                    <th style='text-align: center'>物料单位</th>
                    <th style='text-align: center'>生效时间从</th>
                    <th style='text-align: center'>生效时间至</th>
                    <th style='text-align: center'>是否启用</th>
                    <th style='text-align: center'>操作</th>
                </tr>
                </thead>
                <tbody>

                </tbody>


            </table>
        </div>
    </div>
    <%--分页信息--%>
    <div class="row">
        <%--分页信息--%>
        <div class="col-md-4 col-md-offset-1" style="top:30px ; text-align:right;" id="page_info_area">

        </div>
        <%--分页条--%>
        <div class="col-md-5" id="page_nav_area">

        </div>
        <%--分页选择栏--%>
        <div class="col-md-2" id="page_add_select">
                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    切换分页模式
                    <span class="caret"></span>
                </button>
        </div>
    </div>
</div>

<script type="text/javascript">
    var totalRecore;
    var currentPage;
     pageSize1 = 5;
    <%--1、页面加载完成以后，直接发送一个ajax请求，要到分页数据--%>
    $(function () {
    //    去首页
        to_page(1,pageSize1);
    });
    function to_page(pn,pageSize1) {
        if (!pageSize1) {
            pageSize1 = 5;
        }
        $.ajax({
            url:"${APP_PATH}/items",
            data:{"pn":pn,"pageSize1":pageSize1},
            type:"GET",
            success:function (result) {
            //    显示查询
                build_select_item();
            //    在页面上解析并显示物料数据
                build_items_table(result);
            //    解析并显示分页信息
                build_page_info(result);
            //    解析并显示分页条
                build_page_nav(result);
            //    解析并显示分页选择栏
                build_page_choice();
            }
        });
    }
    function build_items_table(result) {
    //    首先清空table表格内容
        $("#item_table tbody").empty();
    //    生成表格
        var items = result.extend.pageInfo.list;
        $.each(items,function (index,item) {
            var checkBoxTd = $("<td><input type = 'checkbox' class='check_item'/></td>");
            var itemCodeTd = $("<td style='text-align: center'></td>").append(item.itemCode);
            var itemDescriptionTd = $("<td style='text-align: center'></td>").append(item.itemDescription);
            var itemUomTd = $("<td style='text-align: center'></td>").append(item.itemUom);
            var startActiveDateTd = $("<td style='text-align: center'></td>").append(item.startActiveDate);
            var endActiveDateTd = $("<td style='text-align: center'></td>").append(item.endActiveDate);
            var enabledFlagTd = $("<td style='text-align: center'></td>").append(item.enabledFlag=="1"?"是":"否");
            var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
            editBtn.attr("edit-id",item.itemId);
            editBtn.attr("edit-code",item.itemCode);
            var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
                .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
            delBtn.attr("del-id",item.itemId);
            var btnTd = $("<td style='text-align: center'></td>").append(editBtn).append(" ").append(delBtn);
            $("<tr></tr>").append(checkBoxTd)
                .append(itemCodeTd)
                .append(itemDescriptionTd)
                .append(itemUomTd)
                .append(startActiveDateTd)
                .append(endActiveDateTd)
                .append(enabledFlagTd)
                .append(btnTd)
                .appendTo("#item_table tbody")
        });
    }

    //解析并显示分页信息
    function build_page_info(result){
    //    首先清空分页信息
        $("#page_info_area").empty();
    //    生成分页信息
        $("#page_info_area").append("当前显示第"+result.extend.pageInfo.pageNum+"页，" +
            "共"+result.extend.pageInfo.pages+"页," +
            "总"+result.extend.pageInfo.total+"条记录");
        totalRecore = result.extend.pageInfo.total;
        currentPage = result.extend.pageInfo.pageNum;
    }

    //解析并显示分页条
    function build_page_nav(result) {
        //首先清空分页条
        $("#page_nav_area").empty();
        //    显示分页条
        var ul = $("<ul></ul>").addClass("pagination");
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if (result.extend.pageInfo.hasPreviousPage == false) {
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        } else {
            firstPageLi.click(function () {
                to_page(1,pageSize1);
            });
            prePageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum - 1,pageSize1);
            });
        }

        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
        if (result.extend.pageInfo.hasNextPage == false) {
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        } else {
            nextPageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum + 1,pageSize1);
            });
            lastPageLi.click(function () {
                to_page(result.extend.pageInfo.pages,pageSize1);
            });
        }
        ul.append(firstPageLi).append(prePageLi);
        $.each(result.extend.pageInfo.navigatepageNums, function (index, item) {
            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if (result.extend.pageInfo.pageNum == item) {
                numLi.addClass("active");
            }
            numLi.click(function () {
                to_page(item,pageSize1);
            })
            ul.append(numLi);
        })
        ul.append(nextPageLi).append(lastPageLi);
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
    }

    //    解析并显示分页选择栏
    function build_page_choice(){
    //    显示分页选择栏
        $("#page_add_select").addClass("dropdown");
        var onePage = $("<li></li>").append($("<a></a>").append("1条/页").attr("href","#"));
        var twoPage = $("<li></li>").append($("<a></a>").append("2条/页").attr("href","#"));
        var fivePage = $("<li></li>").append($("<a></a>").append("5条/页").attr("href","#"));
        onePage.click(function () {
            pageSize1=1;
            to_page(1,pageSize1);
        });
        twoPage.click(function () {
            pageSize1=2;
            to_page(1,pageSize1);
        });
        fivePage.click(function () {
            pageSize1=5;
            to_page(1,pageSize1);
        });
        var page = $("<ul></ul>").addClass("dropdown-menu").attr("aria-labelledby","dropdownMenu1");
        page.append(onePage).append(twoPage).append(fivePage).appendTo("#page_add_select");
        // $("#page_add_select").append(onePage).append(twoPage);
    }

    //日期设定
    function DatePicker(beginSelector, endSelector) {
        $(beginSelector).datetimepicker(
            {
                language: "zh-CN",
                autoclose: 1,
                startView: 2,
                minView: 2,
                format: "yyyy-mm-dd",
                clearBtn: true,
                todayBtn: false,
                endDate: new Date()
            }).on('changeDate', function (ev) {
            if (ev.date) {
                $(endSelector).datetimepicker('setStartDate', new Date(ev.date.valueOf()))
            } else {
                $(endSelector).datetimepicker('setStartDate', null);
            }
        });

        $(endSelector).datetimepicker(
            {
                language: "zh-CN",
                autoclose: 1,
                startView: 2,
                minView: 2,
                format: "yyyy-mm-dd",
                clearBtn: true,
                todayBtn: false,
                endDate: new Date("2099-12-12"),
            }).on('changeDate', function (ev) {
            if (ev.date) {
                $(beginSelector).datetimepicker('setEndDate', new Date(ev.date.valueOf()))
            } else {
                $(beginSelector).datetimepicker('setEndDate', new Date());
            }

        });
    }

    //    查询
    function build_select_item(){
        DatePicker("#selectStartActiveDate","#selectEndActiveDate");
    };
    
    //点击查询
    $("#search").click(function () {
        pn = 1;
        pageSize1 = 5;
        $.ajax({
            url:"${APP_PATH}/itemS",
            type:"GET",
            // data:{"ssmItems":$("#selectItem form").serialize(),"pn":pn,"pageSize1":pageSize1},
            data:$("#selectItem form").serialize(),
            success:function (result) {
                //    显示查询
                build_select_item();
                //    在页面上解析并显示物料数据
                build_items_table(result);
                //    解析并显示分页信息
                // build_page_info(result);
                $("#page_info_area").empty();
                //    解析并显示分页条
                // build_page_nav(result);
                $("#page_nav_area").empty();
                //    解析并显示分页选择栏
                // build_page_choice();
                $("#page_add_select").empty();
            }
        });
    });

    //    点击新增弹出模块框
    $("#item_add_modal_btn").click(function () {
        $("#itemUom_add_select").empty();
        var uom1 = $("<option></option>").append("米").attr("value","米");
        var uom2 = $("<option></option>").append("平方米").attr("value","平方米");
        var uom3 = $("<option></option>").append("立方米").attr("value","立方米");
        var uom4 = $("<option></option>").append("千克").attr("value","千克");
        var uom5 = $("<option></option>").append("个").attr("value","个");
        var uom6 = $("<option></option>").append("其他").attr("value","其他");
        $("#itemUom_add_select").append(uom1)
            .append(uom2)
            .append(uom3)
            .append(uom4)
            .append(uom5)
            .append(uom6)
        $("#itemAddModal").modal({
            backdrop:"static"
        });
        DatePicker("#startDatepicker","#endDatepicker");
    });

    $("#item_save_btn").click(function () {
    //    将模态框内数据提交给服务器进行保存
    //    发送ajax请求保存物料信息
        $.ajax({
            url:"${APP_PATH}/itemSave",
            type:"POST",
            data:$("#itemAddModal form").serialize(),
            success:function (result) {
                $("#itemAddModal").modal('hide');
                to_page(totalRecore+1,pageSize1)
            }
        });
    });

    //修改
    $(document).on("click",".edit_btn",function () {
        //查出物料信息
        getItem($(this).attr("edit-id"));
        $("#item_update_btn").attr("edit-code",$(this).attr("edit-code"));
        //点击弹出模态框
        $("#itemUom_update_select").empty();
        var uom1 = $("<option></option>").append("米").attr("value","米");
        var uom2 = $("<option></option>").append("平方米").attr("value","平方米");
        var uom3 = $("<option></option>").append("立方米").attr("value","立方米");
        var uom4 = $("<option></option>").append("千克").attr("value","千克");
        var uom5 = $("<option></option>").append("个").attr("value","个");
        var uom6 = $("<option></option>").append("其他").attr("value","其他");
        $("#itemUom_update_select").append(uom1)
            .append(uom2)
            .append(uom3)
            .append(uom4)
            .append(uom5)
            .append(uom6)
        $("#itemUpdateModal").modal({
            backdrop:"static"
        });
        DatePicker("#updateStartDatepicker","#updateEndDatepicker");
    });

    //查出物料信息
    function getItem(id){
        $.ajax({
            url:"${APP_PATH}/itemSelect/"+id,
            type:"GET",
            success:function (result) {
                // console.log(result);
                var itemData = result.extend.item;
                $("#itemCode_update_static").text(itemData.itemCode);
                $("#itemDescription_update_input").val(itemData.itemDescription);
                $("#itemUpdateModal select").val([itemData.itemUom]);
                $("#updateStartDatepicker").val(itemData.startActiveDate);
                $("#updateEndDatepicker").val(itemData.endActiveDate);
                $("#itemUpdateModal input[name=enabledFlag]").val([itemData.enabledFlag])
            }
        });
    };

    //点击修改按钮，修改物料信息
    $("#item_update_btn").click(function () {
        $.ajax({
            url:"${APP_PATH}/itemU/"+$(this).attr("edit-code"),
            type:"PUT",
            data:$("#itemUpdateModal form").serialize(),
            success:function (result) {
                // alert(result.msg);
                $("#itemUpdateModal").modal("hide");
                to_page(currentPage,pageSize1);

            }
        });
    });

    //单个删除
    $(document).on("click",".delete_btn",function () {
        // alert($(this).parents("tr").find("td:eq(1)").text());
        var itemDescription = $(this).parents("tr").find("td:eq(2)").text();
        var itemId = $(this).attr("del-id");
        if (confirm("确认删除【"+itemDescription+"】吗？")) {
        //    确认：发送ajax请求删除
            $.ajax({
                url:"${APP_PATH}/item/"+itemId,
                type:"DELETE",
                success:function (result) {
                    alert(result.msg);
                    to_page(currentPage,pageSize1);
                }
            })
        }
    });

//    完成全选、全不选
    $("#check_all").click(function () {
        $(".check_item").prop("checked",$(this).prop("checked"));
    });
    
//    单框全选，头部也打勾。反之则反
    $(document).on("click",".check_item",function () {
    //    判断当前是否勾选满
        var flag = $(".check_item:checked").length==$(".check_item").length;
        $("#check_all").prop("checked",flag);
    });

//    点击，删除勾选项
    $("#item_delete_all_btn").click(function () {
        var itemDes = "";
        var del_idstr = "";
        $.each($(".check_item:checked"),function () {
            itemDes += $(this).parents("tr").find("td:eq(2)").text()+",";
            del_idstr += $(this).parents("tr").find("td:eq(1)").text()+"-";
        });
        //去除拼接时itemDes末尾多余的逗号
        itemDes = itemDes.substring(0,itemDes.length-1);
        del_idstr = del_idstr.substring(0,del_idstr.length-1);
        if (confirm("确认删除【"+itemDes+"】吗？")) {
        //    发生ajax请求删除
            $.ajax({
                url:"${APP_PATH}/itemD/"+del_idstr,
                type:"DELETE",
                success:function (result) {
                    alert(result.msg);
                    to_page(currentPage,pageSize1);
                }
            });
        }
    });


</script>

</body>
</html>
