<%@ page import="cn.tommyyang.erweimastore.utils.Constants" %><%--
  Created by IntelliJ IDEA.
  User: tommyyang
  Date: 2017/11/23
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<% String webRoot = Constants.WebRoot;%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<%=webRoot%>/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="<%=webRoot%>/css/common.css"/>
    <script charset="utf-8" src="<%=webRoot%>/js/jquery-1.10.2.min.js"></script>
    <script charset="utf-8" src="<%=webRoot%>/js/bootstrap.min.js"></script>

    <style type="text/css">
        body {
            margin: 0 auto;
            height: 100%
        }

        #submit {
            text-align: center;
            margin-left: 410px;
        }

        #divimg {
            margin-top: 15px;
            height: 30px;
        }

        #divtype {
            height: 30px;
        }

        #combobox {
            margin-top: -110px;
            margin-left: 30px;
        }

        #picture {
            margin-top: -25px;
            margin-left: 80px;
        }

        .input-group {
            width: 900px;
        }
    </style>
    <title>添加店铺</title>
</head>
<body>
<font style="color: red; font-size: 14px; font-weight: bold; margin-left: 400px;"></font>
<form id="addproductform" action="<%=webRoot%>/product/addproduct.do" enctype="multipart/form-data" method="post">
    <br/>
    <div class="input-group">
        <span class="input-group-addon">商品名</span> <input type="text"
                                                          name="name" class="form-control"
                                                          placeholder="商品名">
    </div>
    <div class="input-group">
        <span class="input-group-addon">商品价格</span> <input type="text"
                                                           name="price" class="form-control" placeholder="商品价格">
    </div>
    <div class="input-group">
        <span class="input-group-addon">商品折扣</span> <input type="text"
                                                           name="percent" class="form-control" placeholder="商品折扣">
    </div>

    <div id="divimg">
        <font class="font">添加图片:</font>
        <input type="file" name="productimg" id="picture" label="图片"/>
        <font style="color: red; font-size: 14px; font-weight: bold; margin-left: 400px;"></font>
    </div>
    <div id="divtype">
        <font class="font">选择加入店铺:</font>
        <select id="combobox" name="storeid" label="店铺">

        </select>
    </div>
    <br/>
    <div>
        <input id="submit" class="btn btn-success btn-lg" type="submit"
               value="添加">(提交快捷键: Ctrl + Enter)
    </div>
</form>
</body>
</html>

<script>
    $(document).ready(
        $(function(){
            $.ajax(
                {
                    type: 'GET',
                    url: '<%=webRoot%>/store/getstoreinfo.do',
                    dataType: 'json',
                    success: function (data) {
                        var html = '';
                        $('#combobox').empty();
                        $.each(data,function (index, item) {
                            html += '<option value='+ item.sid +'>' + item.sname + '</option>';
                        });
                        $(html).appendTo('#combobox');
                    }
                }
            );
        })
    );
</script>
