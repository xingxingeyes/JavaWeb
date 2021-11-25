<%--
  Created by IntelliJ IDEA.
  User: kai.lv
  Date: 2021/11/24
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    我是a.jsp文件
    <%
        System.out.println("a.jsp页面执行了");
        Object user = session.getAttribute("user");
        if (user == null) {
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
    %>

</body>
</html>
