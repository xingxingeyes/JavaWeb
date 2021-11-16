<%--
  Created by IntelliJ IDEA.
  User: kai.lv
  Date: 2021/11/11
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>scope2.jsp页面</h1>

pagpageContext 域是否有值<%=pageContext.getAttribute("key")%><br>
request 域是否有值<%=request.getAttribute("key")%><br>
session 域是否有值<%=session.getAttribute("key")%><br>
application 域是否有值<%=application.getAttribute("key")%><br>

</body>
</html>
