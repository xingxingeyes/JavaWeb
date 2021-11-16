<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: kai.lv
  Date: 2021/11/12
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
//empty 运算可以判断一个数据是否为空，如果为空返回true，繁殖false
//    以下几种情况为空：
//        1.值为null的时候为空
    request.setAttribute("emptyNull",null);
//        2.值为空串的时候为空
    request.setAttribute("emptyStr","");
//        3.值是Object类型的数组长度为零的时候
    request.setAttribute("emptyObjArr",new Object[]{});
//        4.list集合元素个数为零
    request.setAttribute("emptyList",new ArrayList<>());
//        5.map集合元素个数为零
    request.setAttribute("emptyMap",new HashMap<>());
%>
    <%
        request.setAttribute("emptyNull",null);
    %>
    ${empty emptyNull}<br>
    ${empty emptyStr}<br>
    ${empty emptyObjArr}<br>
    ${empty emptyList}<br>
    ${empty emptyMap}<br>

</body>
</html>
