<%--
  Created by IntelliJ IDEA.
  User: Jzxxxx
  Date: 2020/9/16
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}">
    <title>Title</title>
</head>
<body>
     ${requestScope.list}
</body>
</html>
