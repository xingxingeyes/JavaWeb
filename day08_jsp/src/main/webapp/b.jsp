<%--
  Created by IntelliJ IDEA.
  User: kai.lv
  Date: 2021/11/11
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>

<!-- autoFlush 属性：设置当out输出缓冲区满了之后，是否自动刷新冲级区。默认值是true。
     buffer 属性：设置out缓冲区的大小。默认是8kb
     errorPage 属性：表示错误后自动跳转去的路径
                    这个路径一般都是已斜杠大头，他表示请求地址为http://ip:prot/工程路径/
                    映射到代码的web目录
     isErrorPage 属性：设置当前jsp页面是否是错误信息页面。默认是false。如果是true可以捕获异常信息。
     session 属性：设置访问当前jsp页面，是否会创建HttpSession对象。默认是true。
     extends 属性：设置jsp翻译出来的java类默认继承谁。

autoFlush="true"
buffer="8kb"
errorPage="/error500.jsp"
isErrorPage="true"
session="true"
extends="javax.servlet.HttpServlet"
-->
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    这是b.jsp
    <%
        int a = 100/0;
    %>
<%-- 三种注释--%>
<!-- html注释，只能注释html-->
<%
    // 单行java注释  只能注释java代码
    /**
     * 多行java注释
     */
%>
<%-- 这是jsp注释，在jsp页面中能注释一切--%>

</body>
</html>
