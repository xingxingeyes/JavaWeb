<%--
  Created by IntelliJ IDEA.
  User: kai.lv
  Date: 2021/11/12
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    request.setAttribute("key","值");
%>
<%-- 表达式输出null值的时候输出的是:null-%>
    表达式脚本输出:<%=request.getAttribute("key")==null?"":request.getAttribute("key")%><br>
<%-- EL表达式输出null值的时候输出的是:""--%>
    EL表达式输出key的值是:${key}

</body>
</html>
