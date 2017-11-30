<%--
  Created by IntelliJ IDEA.
  User: tommyyang
  Date: 2017/11/30
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>店铺展示</title>
    <head>

        <!-- meta使用viewport以确保页面可自由缩放 -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- 引入 jQuery Mobile 样式 -->
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">

        <!-- 引入 jQuery 库 -->
        <script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

        <!-- 引入 jQuery Mobile 库 -->
        <script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

    </head>
</head>
<body>
<div data-role="page" id="pageone">
    <div data-role="header">
        <h1>店铺展示</h1>
    </div>

    <div data-role="main" class="ui-content">
        <div class="ui-grid-b ui-responsive">
            <div class="ui-block-a">
                <a href="#" class="ui-btn ui-corner-all ui-shadow">第一列按钮</a><br>
                <span>第一列: 这是一些文本。 这是一些文本。 这是一些文本。 这是一些文本。 这是一些文本。</span>
            </div>
            <div class="ui-block-b">
                <a href="#" class="ui-btn ui-corner-all ui-shadow">第二列按钮</a><br>
                <span>第二列: 这是一些文本。 这是一些文本。 这是一些文本。 这是一些文本。</span>
            </div>
            <div class="ui-block-c">
                <a href="#" class="ui-btn ui-corner-all ui-shadow">第三列按钮</a><br>
                <span>第三列: 这是一些文本。 这是一些文本。 这是一些文本。 这是一些文本。</span>
            </div>
        </div>
    </div>
</div>
</body>
</html>
