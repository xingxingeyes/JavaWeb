<%--
  Created by IntelliJ IDEA.
  User: kai.lv
  Date: 2021/11/12
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--关系运算--%>
    ${ 12 == 12 } 或 ${ 12 eq 12}<br>
<%--逻辑运算--%>
    ${ 12==12 && 12 >11 } 或 ${ 12==12 and 12 >11 }<br>
<%--算术运算--%>
    ${ 12 + 12 }<br>
    ${ 18 / 12 } 或 ${ 18 div 12 }<br>
    ${ 18 % 12 } 或 ${ 18 mod 12}<br>
</body>
</html>
