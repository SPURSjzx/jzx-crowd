<%--
  Created by IntelliJ IDEA.
  User: Jzxxxx
  Date: 2020/9/16
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}">
</head>
<body>
     ${requestScope.list}
     ${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}
</body>
</html>
