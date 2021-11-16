<%--
  Created by IntelliJ IDEA.
  User: kai.lv
  Date: 2021/11/12
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%--
            request.getScheme() 它可以获取请求的协议
            request.getServerName() 获取请求的服务器的ip地址
            requset.getServerPort() 获取请求服务器的端口号
            request.getConetxtPath() 获取当前工程路径
            request.getMethod() 获取请求方式 get/post
            request.getRemoteHost() 获取客户端的ip地址
            session.getId() 获取回话的唯一标识
        --%>


        ${pageContext}
        1.协议： ${pageContext.request.scheme}
        2.服务器ip：${pageContext.request.serverName}
        3.服务器端口：${pageContext.request.serverPort}
        4.获取工程路径：${pageContext.request.contextPath}
        5.获取请求方式：${pageContext.request.method}
        6.获取客户端IP地址：${pageContext.request.remoteHost}
        7.获取会话id编号：${pageContext.request.session.id}

</body>
</html>
