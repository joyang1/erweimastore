<%--
  Created by IntelliJ IDEA.
  User: tommyyang
  Date: 2017/11/23
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
                pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/css/common.css"/>
    <script charset="utf-8" src="/js/jquery-1.10.2.min.js"></script>
    <script charset="utf-8" src="/js/bootstrap.min.js"></script>

    <style type="text/css">
        body {
            margin: 0 auto;
            height: 100%
        }

        #submit {
            text-align: center;
            margin-left: 410px;
        }

        .input-group {
            width: 900px;
        }
    </style>
    <title>添加店铺</title>
</head>
<body>
<font style="color: red; font-size: 14px; font-weight: bold; margin-left: 400px;"></font>
<form id="addstoreform" action="admin-addphone" enctype="multipart/form-data" method="post">
    <br/>
    <div class="input-group">
        <span class="input-group-addon">店铺名</span> <input type="text"
                                                          name="product.phonename" class="form-control"
                                                          placeholder="店铺名">
    </div>
    <br/>
    <div>
        <input id="submit" class="btn btn-success btn-lg" type="submit"
               value="添加">(提交快捷键: Ctrl + Enter)
    </div>
    </form>
</body>
</html>
