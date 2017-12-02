<%@ page import="cn.tommyyang.erweimastore.utils.Constants" %><%--
  Created by IntelliJ IDEA.
  User: TommyYang
  Date: 2017/11/26
  Time: 18:11
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% String webRoot = Constants.WebRoot;%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<%=webRoot%>/EasyUI/themes/icon.css" rel="stylesheet" />
    <link href="<%=webRoot%>/EasyUI/themes/default/easyui.css" rel="stylesheet" />
    <link href="<%=webRoot%>/css/common.css" rel="stylesheet">
    <script src="<%=webRoot%>/EasyUI/jquery.min.js"></script>
    <script src="<%=webRoot%>/EasyUI/jquery.easyui.min.js"></script>
    <script src="<%=webRoot%>/EasyUI/locale/easyui-lang-zh_CN.js"></script>
    <title>商品列表</title>
</head>
<body>
<table id="dg">
</table>
</body>
</html>
<script type="text/javascript">
    $('#dg').datagrid({
        loadMsg : "数据加载中...",
        fit : true,
        singleSelect : true,
        fitColumns : true,
        pagination: true,
        url : '<%=webRoot%>/product/getproductinfo.do',
        method: 'get',
        onSelect : function() {
            $('#btn_remove').linkbutton('enable');

        },
        onUnselect : function() {
            $('#btn_remove').linkbutton('disable');

        },
        columns : [ [ {
            field : 'pid',
            title : '商品序号',
            width : 20
        }, {
            field : 'pname',
            title : '商品名称',
            width : 40
        },{
            field : 'purl',
            title : '商品路径',
            width : 80
        },{
            field : 'pprice',
            title : '商品价格',
            width : 20
        },{
            field : 'ppercent',
            title : '商品折数',
            width : 20
        } ,{
            field : 'pstorename',
            title : '所属店铺',
            width : 40
        } ] ],
        toolbar : [ {
            iconCls : 'icon-add',
            id : 'btn-add',
            text : '添加',
            handler : function() {
                window.location.href="<%=webRoot%>/product/productpost.do";
            }
        }, '-', {
            iconCls : 'icon-remove',
            id : 'btn_remove',
            text : '删除',
            disabled : true,
            handler : function() {
                var row = $('#dg').datagrid('getSelected');
                $.messager.confirm('提示', '您确定要删除吗？', function(r){
                    if (r){
                        $.ajax({
                            url : "<%=webRoot%>/product/delproduct.do",
                            type : "post",
                            dataType : "json",
                            async : false,
                            //传送请求数据
                            data : {
                                "id" : row.pid,
                                "path" : row.purl
                            },
                            //根据返回值进行状态显示
                            success : function(data) {
                                if (data == "1") {
                                    $.messager.alert('我的消息', '删除成功!', '提示');
                                    $('#dg').datagrid('reload',null);
                                } else {
                                    $.messager.alert('我的消息', '删除失败!', '提示');
                                    $('#dg').datagrid('reload',null);

                                }
                            }
                        });
                    }
                });
            }
        }]
    });


    //分页
    var pagenum = 10;
    load();
    function load() {
        var p = $('#dg').datagrid('getPager');
        $(p).pagination({
            pageSize: pagenum, //每页显示的记录条数，默认为10
            pageList: [10, 20, 30], //可以设置每页记录条数的列表
            beforePageText: '第', //页数文本框前显示的汉字
            afterPageText: '页    共 {pages} 页',
            displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
            onBeforeRefresh: function(pageNumberNow, pageSizeNow) {
                pagenum = pageSizeNow;
                $('#dg').datagrid('reload',null);
                load();
            }
        });
    }
</script>
