<%--
  Created by IntelliJ IDEA.
  User: tommyyang
  Date: 2017/11/23
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="/EasyUI/themes/icon.css" rel="stylesheet" />
    <link href="/EasyUI/themes/default/easyui.css" rel="stylesheet" />
    <link href="/css/common.css" rel="stylesheet">
    <script src="/EasyUI/jquery.min.js"></script>
    <script src="/EasyUI/jquery.easyui.min.js"></script>
    <script src="/EasyUI/locale/easyui-lang-zh_CN.js"></script>
    <title>店铺列表</title>
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
        url : '/store/getstoreinfo.do',
        method: 'get',
        onSelect : function() {
            $('#btn_remove').linkbutton('enable');

        },
        onUnselect : function() {
            $('#btn_remove').linkbutton('disable');

        },
        columns : [ [ {
            field : 'sid',
            title : '店铺序号',
            width : 20
        }, {
            field : 'sname',
            title : '店铺名称',
            width : 40
        },{
            field : 'surl',
            title : '店铺路径',
            width : 80
        },{
            field : 'scode',
            title : '店铺二维码',
            width : 80
        } ] ],
        toolbar : [ {
            iconCls : 'icon-add',
            id : 'btn-add',
            text : '添加',
            handler : function() {
                window.location.href="/store/storepost.do";
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
                            url : "/store/delstore.do",
                            type : "post",
                            dataType : "json",
                            async : false,
                            //传送请求数据
                            data : {
                                "id" : row.sid,
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
