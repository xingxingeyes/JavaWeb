<%--
  Created by IntelliJ IDEA.
  User: kai.lv
  Date: 2021/11/12
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
        http://localhost:8080/day09_EL_JSTL/other_EL_Obj.jsp?username=abc&password=123&hobby=Java&hobby=C++
--%>
        输出请求参数username的值：${param.username}<br>
        输出请求参数password的值：${param.password}<br>
        输出请求参数hobby的值：${paramValues.hobby[0]}<br>
        输出请求参数hobby的值：${paramValues.hobby[1]}<br>
        输出请求参数username的值：${paramValues.username[0]}<br>
        <hr>
        输出请求头【Connection】的值：${header.connection}
        输出请求头【User-Agent】的值：${header['User-Agent']}<br>
        输出请求头【User-Agent】的值：${headerValues['User-Agent'][0]}<br>
        <hr>

        获取Cookie的名称：${cookie.JSESSIONID.name}<br>
        获取Cookid的值：${cookie.JSESSIONID.value}<br>
        <hr>

        输出&lt;Context-Param&gt;username的值：${initParam.username}<br>
        输出&lt;Context-Param&gt;url的值：${initParam.url}


</body>
</html>
