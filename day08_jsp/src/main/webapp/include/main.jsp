<%--
  Created by IntelliJ IDEA.
  User: kai.lv
  Date: 2021/11/11
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    头部信息<br>
    主题内容<br>

<%--
 静态包含  <%@include file=""%>
    静态包含的特点：
        1.静态包含不会翻译被包含的jsp页面
        2.静态包含其实是把被包含的jsp页面的代码拷贝到包含的位置执行输出
--%>
<%@include file="/include/footer.jsp"%>

<%--
 动态包含 <jsp:include page=""/>
    page 属性是指定你要包含的jsp页面的路径
    动态包含也可以像静态包含一样，把被包含的内容执行输出到包含位置

    动态包含的特点：
        1.动态包含会把包含的jsp页面也翻译成java代码
        2.动态包含底层代码使用如下：
            JspRuntimeLibrary.include(request,response,"/include/footer.jsp",out,false);
        3.动态包含还可以传递参数
 --%>

    <jsp:include page="/include/footer.jsp">
        <jsp:param name="username" value="bbj"/>
        <jsp:param name="password" value="bbj"/>
    </jsp:include>



</body>
</html>
