<%--
  Created by IntelliJ IDEA.
  User: Jzxxxx
  Date: 2020/9/16
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn1").click(function () {
                $.ajax({
                    "url":"send/array.html",
                    "type":"post",
                    "data":{
                        "array":[5,7,1]
                    },
                    "dataType":"txt",
                    "success":function(response){
                        alert(response);
                    },
                    "error":function(response){
                        alert(response);
                    }
                });
            });
            $("#btn2").click(function () {
                layer.msg("测试");
            });
        });
    </script>
</head>
<body>
    <a href="test/ssm.html">ssm环境整合</a>
    <br/>
    <button id="btn1">Test RequsetBody</button>0
    <button id="btn2">layer工具</button>
    <a href="admin/to/login/page.html">管理员登陆</a>
</body>
</html>
