<%@ page import="sun.util.locale.StringTokenIterator" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="com.kai.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kai.lv
  Date: 2021/11/12
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            border: 1px black solid;
            width: 600px;
            border-collapse: collapse;
        }
        td,th{
            border: 1px black solid;
            width: 600px;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<%--
        begin属性设置遍历的开始索引
        end属性设置结束的索引
        var属性表示循环的变量（也是当前正在遍历的数据）
        for(int i = 1; i < 10; i++){}

--%>

        <table border="1">
        <c:forEach begin="1" end="10" var="i">
            <tr>
                <td>第${i}行</td>
            </tr>
        </c:forEach>

        </table>
<%--        <c:forEach begin="1" end="10" var="i">--%>
<%--            <h1>${i}<br>--%>
<%--        </c:forEach>--%>

        <hr>
<%--
            遍历Object数组
            for(Object: arr)
                items 表示遍历的数据源（遍历的集合）
--%>
<%
        request.setAttribute("arr", new String[]{"2134234","34345656","346546346"});
%>
        <c:forEach items="${requestScope.arr}" var="item">
            ${item}<br>
        </c:forEach>
        <hr>
        <%
            Map<String, Object> map = new HashMap<>();
            map.put("key1", "value1");
            map.put("key2", "value2");
            map.put("key3", "value3");

            request.setAttribute("map",map);
        %>

        <c:forEach items="${requestScope.map}" var="entry">
            <h1>${entry.key}==${entry.value}</h1>

        </c:forEach>
        <hr>
<%--
        遍历list集合

--%>
<%
    List<Student> studentList = new ArrayList<>();
    for (int i = 1; i <= 10; i++) {
        studentList.add(new Student(i,"username"+i,"pass"+1,18+i,"phone"+i));
    }
    request.setAttribute("stus", studentList);
%>
    <table border="1">
        <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>年龄</th>
            <th>电话</th>
            <th>操作</th>
        </tr>

<%--
        items 表示遍历的集合
        begin属性设置遍历的开始索引
        end属性设置结束的索引
        var属性表示循环的变量（也是当前正在遍历的数据）
        step 睡醒表示遍历的步长值
        varStatus 属性表示当前遍历到的数据的状态
--%>
        <c:forEach begin="2" step="3" varStatus="status" end="7" items="${requestScope.stus}" var="stu">
        <tr>
            <td>${stu.id}</td>
            <td>${stu.username}</td>
            <td>${stu.password}</td>
            <td>${stu.age}</td>
            <td>${stu.phone}</td>
            <td>${status}</td>
        </tr>
        </c:forEach>

    </table>






</body>
</html>
