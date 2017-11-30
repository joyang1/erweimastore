<%--
  Created by IntelliJ IDEA.
  User: tommyyang
  Date: 2017/11/30
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>二维码生成</title>
</head>
<body>
<div class="input-group">
    <span class="input-group-addon">URL</span> <input type="text"
                                                      name="url" class="form-control"
                                                      placeholder="输入生成二维码的URL">
    <font class="errorfont">
        <span id="urlerror"></span>
    </font>
</div>

<p id = "dispalyText" style="display: none; margin-top: 10px"><span>二维码如下:</span></p>
<div style="width: 20px; height: 20px;">
    <img id="qrcode">
</div>

<div>
    <input id="submit" class="btn btn-success btn-lg" type="button"
           value="Generate">(提交快捷键: Ctrl + Enter)
</div>
</body>
</html>

<script>
    $(document).ready(
        $('#submit').click(function () {
            $.ajax(
                {
                    type: 'GET',
                    url: '/store/generateqrcode.do',
                    dataType: 'json',
                    data: {url: $("input[name='url']").val()},
                    async:true,
                    success: function (data) {
                        $("#dispalyText").css('display','block');
                        $("#qrcode").attr("src", data.data);
                    }
                }
            );
        })
    );
</script>
