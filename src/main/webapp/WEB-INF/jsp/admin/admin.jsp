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
    <script src="/js/time.js" charset="UTF-8"></script>
    <title>管理员管理界面</title>
    <style type="text/css">
        .infofont {
            font-size: 18px;
            font-style: normal;
            color: graytext;
        }

        #time {
            float: right;
            font-size: 16px;
            font-weight: bold;
        }

        a {
            text-decoration: none;
            color: #00ff00;
            font-size: 10px;
        }

        a:hover {
            color: turquoise;
            font-size: 15px;
        }
    </style>
</head>
<body class="easyui-layout">
<div data-options="region:'north',title:'后台管理系统',split:false"
     style="height: 100px; text-align: center">
    <font class="infofont">欢迎管理员:
        ${sessionScope.get('admin').nickname}
    </font>
    <font id="time">
        <script>
            ShowTime(time);
        </script>
    </font>

</div>
<div data-options="region:'west',title:'后台管理导航',split:false" id="aa"
     class="easyui-accordion" style="width: 200px; height: 650px;">
    <div title="用户管理" data-options="iconCls:'icon-user',selected:true"
         style="overflow: auto; padding: 10px;">
        <a href="#" onclick="addTab('管理员管理', 'adminmanage.do', 'icon-user')"><img
                src="/EasyUI/themes/icons/user.png">管理员信息管理</a><br /> <br />
    </div>
    <div title="店铺商品管理" data-options="iconCls:'icon-save'"
         style="padding: 10px;">
        <a href="#"
           onclick="addTab('店铺管理', '/store/storemanage.do','icon-filter')"><img
                src="/EasyUI/themes/icons/filter.png">店铺管理</a><br /> <br /> <a
            href="#" onclick="addTab('商品管理', '/product/productmanage.do')"><img
            src="/EasyUI/themes/icons/filter.png">商品管理</a><br /> <br />
    </div>
    <div title="店铺商品发布" data-options="iconCls:'icon-save'"
         style="padding: 10px;">
        <a href="#" onclick="addTab('店铺发布', '/store/storepost.do','icon-filter')"><img
                src="/EasyUI/themes/icons/filter.png">店铺发布</a><br /> <br />
        <a href="#"
           onclick="addTab('商品发布', '/product/productpost.do','icon-filter')"><img
                src="/EasyUI/themes/icons/filter.png">商品发布</a><br /> <br />
    </div>
</div>
<div data-options="region:'center',title:'信息中心',split:false" id="tt"
     class="easyui-tabs"
     style="height: 100px; padding: 5px; background: #eee;">
    <div title="欢迎" style="padding: 20px;">
        <marquee scrollamount="2" direction="right">
            <h1>欢迎使用二维码Store后台管理系统！</h1>
            <h2>欢迎使用二维码Store后台管理系统！</h2>
            <h3>欢迎使用二维码Store后台管理系统！</h3>
        </marquee>
    </div>
</div>
</body>

</html>
<script type="text/javascript">
    function addTab(title, url, img) {
        if ($('#tt').tabs('exists', title)) {
            $('#tt').tabs('select', title);
        } else {
            var content = '<iframe scrolling="auto" frameborder="0"  src="'
                + url + '"  style="width:100%;height:100%;"></iframe>';
            $('#tt').tabs('add', {
                title : title,
                content : content,
                closable : true,
                iconCls : img
            });
        }
    }


</script>