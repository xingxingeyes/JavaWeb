<%--
  Created by IntelliJ IDEA.
  User: kai.lv
  Date: 2021/11/12
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    pageContext.setAttribute("key", "pageContext");
    request.setAttribute("key", "pageContext");
    session.setAttribute("key", "pageContext");
    application.setAttribute("key", "pageContext");
%>
<%--
往四个域中都保存了相同的key的数据
EL 当四个域中都有相同的key的数据的时候，EL表达式会从小到大的顺序获取域的值
--%>
    ${key}

</body>
</html>
