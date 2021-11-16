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
<h1>scope.jsp页面</h1>
<%
    // 往四个域中都分别保存了数据
    pageContext.setAttribute("key", "pageContext");
    request.setAttribute("key","request");
    session.setAttribute("key","session");
    application.setAttribute("key","application");
%>
    pagpageContext 域是否有值<%=pageContext.getAttribute("key")%><br>
    request 域是否有值<%=request.getAttribute("key")%><br>
    session 域是否有值<%=session.getAttribute("key")%><br>
    application 域是否有值<%=application.getAttribute("key")%><br>

<%
//    request.getRequestDispatcher("scope2.jsp").forward(request,response);
%>
<%--
        <jsp:forward page=""></jsp:forward> 转发标签 和上面的功能一样
            page 属性设置请求转发的路径
--%>
<jsp:forward page="scope2.jsp"></jsp:forward>

</body>
</html>
