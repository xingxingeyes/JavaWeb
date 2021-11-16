<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: kai.lv
  Date: 2021/11/12
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Map<String, Object> map = new HashMap<>();
        map.put("a.a.a", "aaaValue");
        map.put("b+b+b", "bbbValue");
        map.put("c-c-c", "cccValue");
        request.setAttribute("map",map);
    %>
<%-- 有特殊字符的key 要用 ['']取值 例子 ${map.['a.a.a']}  --%>
        ${map.['a.a.a']}
        ${map.['b+b+b']}
        ${map.['c-c-c']}

</body>
</html>
