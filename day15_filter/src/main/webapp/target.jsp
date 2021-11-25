<%--
  Created by IntelliJ IDEA.
  User: kai.lv
  Date: 2021/11/24
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        System.out.println("target.jsp的线程："+Thread.currentThread().getName());
        System.out.println("target.jsp request域"+ request.getParameter("username"));
        System.out.println("target.jsp页面代码执行了");
    %>

</body>
</html>
