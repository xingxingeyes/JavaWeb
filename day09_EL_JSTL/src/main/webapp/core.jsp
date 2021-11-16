<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kai.lv
  Date: 2021/11/12
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
        <c:set />
            作用：set标签可以往域里面保存数据

            域对象.setAttribute(key,value);
            scope属性设置保存到哪个域
            page表示PageContext域
            request表示Request域
            application表示Application域
            var属性设置key是多少
            value属性设置值是多少
--%>
        保存之前：${requestScope.abc}
        <c:set scope="request" var="abc" value="abcValue"/>
        保存之后：${requestScope.abc}

<%--
        <c:if />
            if标签用来做if判断的

            test属性表示判断的条件（使用EL表达式输出）
--%>
        <c:if test="${12==12}">
            <h1>12等于12</h1>
        </c:if>
        <c:if test="${12!=12}">
            <h1>12不等于12</h1>
        </c:if>

<%--
        <c:choose><c:when><c:otherwise>标签
        作用：多路判断。跟switch...cash...default非常接近

        choose标签开始选择判断
        when标签表示每一种判断情况
            test属性表示当前这种判断情况的值

        <c:choose><c:when><c:otherwise>标签注意的几点
            1.标签里不能使用html注释，要使用jsp注释
            2.when标签的父标签一定要是choose标签
--%>
        <c:set scope="request" var="height" value="158"/>

        <c:choose>
            <c:when test="${requestScope.height > 190}">
                <h2>小巨人</h2>
            </c:when>
            <c:when test="${requestScope.height > 180}">
                <h2>很高</h2>
            </c:when>
            <c:when test="${requestScope.height > 170}">
                <h2>还可以</h2>
            </c:when>
            <c:otherwise >
                <c:choose>
                    <c:when test="${requestScope.height > 160}">
                        <h2>身高160</h2>
                    </c:when>
                    <c:when test="${requestScope.height > 150}">
                        <h2>身高150</h2>
                    </c:when>
                    <c:when test="${requestScope.height > 140}">
                        <h2>身高140</h2>
                    </c:when>
                </c:choose>
            </c:otherwise>
        </c:choose>



</body>
</html>
