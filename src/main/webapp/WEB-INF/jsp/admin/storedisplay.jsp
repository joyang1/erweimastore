<%@ page import="cn.tommyyang.erweimastore.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.tommyyang.erweimastore.utils.Constants" %><%--
  Created by IntelliJ IDEA.
  User: tommyyang
  Date: 2017/11/30
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<% String webRoot = Constants.WebRoot;%>

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
        <link rel="stylesheet" href="<%=webRoot%>/css/bootstrap.min.css"/>
        <script charset="utf-8" src="<%=webRoot%>/js/bootstrap.min.js"></script>

    </head>
</head>
<body>

<%
    List<Product> products = (List<Product>) request.getAttribute("products");
%>


<div data-role="page" id="pageone">
    <div data-role="header">
        <h1>店铺展示</h1>
        <% if (products == null || products.size() == 0) {%>
        <h1>该店铺还没有商品！请去后台添加</h1>
        <% }%>
    </div>

    <div data-role="main" class="ui-content">
        <div class="ui-grid-b ui-responsive">
            <%
                if (products != null && products.size() > 0) {
                    for (int i = 0; i < products.size(); i++) {
                        if (i % 3 == 0) {
            %>
            <% if (products.get(i) != null) { %>
            <div class="ui-block-a">
                <a href="#"><img
                        src="<%= products.get(i).getPicturePath()%>" class="img-rounded" style="width: 140px; height:140px;"></a><br>
                <span>折扣:<%=products.get(i).getPercent()%></span><br>
                <span>价格:<%=products.get(i).getPrice()%></span>
            </div>
            <% }
                if ((i+1) < products.size() && products.get(i + 1) != null) { %>
            <div class="ui-block-b">
                <a href="#"><img src="<%= products.get(i+1).getPicturePath()%>" class="img-rounded" style="width: 140px; height:140px;"></a><br>
                <span>折扣:<%=products.get(i + 1).getPercent()%></span><br>
                <span>价格:<%=products.get(i + 1).getPrice()%></span>
            </div>
            <% }
                if ((i+2) < products.size() && products.get(i + 2) != null) { %>
            <div class="ui-block-c">
                <a href="#"><img src="<%= products.get(i+2).getPicturePath()%>" class="img-rounded" style="width: 140px; height:140px;"></a><br>
                <span>折扣:<%=products.get(i + 2).getPercent()%></span><br>
                <span>价格:<%=products.get(i + 2).getPrice()%></span>
            </div>
            <%
                            }
                        }
                    }
                }
            %>

        </div>
    </div>
</div>
</body>
</html>
