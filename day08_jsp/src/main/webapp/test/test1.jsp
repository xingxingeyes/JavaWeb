<%--
  Created by IntelliJ IDEA.
  User: kai.lv
  Date: 2021/11/11
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">

table{
    width: 600px;
}

    </style>
</head>
<body>
<%-- 在jsp页面中打印九九乘法表--%>
<h1 align="center">九九乘法口诀表</h1>
<table align="center" >
    <% for (int i = 1; i < 10; i++) { %>
        <tr>
                <% for (int j = 1; j <= i; j++) { %>
            <td><%=i+"x"+j+"="+i*j+" "%></td>
                <% } %>
        </tr>

    <% } %>




</table>
<%
    for (int i = 1; i < 10; i++) {
        for (int j = 1; j <= i; j++) {
            System.out.print(i+"x"+j+"="+i*j+" ");
        }
        System.out.println();
    }
%>

</body>
</html>
