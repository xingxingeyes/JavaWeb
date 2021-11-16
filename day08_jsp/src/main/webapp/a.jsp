<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: kai.lv
  Date: 2021/11/11
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%--1.声明类属性--%>
<%!
    private Integer id;
    private String name;
    private static Map<String, Object> map;
%>
<%--2.声明static静态代码块--%>
<%!
    static {
        map = new HashMap<String, Object>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
    }
%>
<%--3.声明类方法--%>
<%!
    public int abc() {
        return 12;
    }
%>
<%--4.生成内部类--%>
<%!
    public static class A {
        private Integer id = 12;
    }
%>
<%--
表达式脚本 向页面输出内容。
         表达式脚本 翻译到 Servlet 程序的 service 方法中 以 out.print() 打印输出
--%>

<%=12%><br/>
<%=12.2%><br/>
<%="我是字符串"%><br/>
<%=request.getParameter("username")%>

<%--
代码脚本 可以在jsp页面中，编写自己需要的任意java语句
        代码脚本的内容都会被翻译到servlet程序的service()方法中
        service()里的方法 代码脚本里面都能用
        还可以由多个代码脚本组合完成一个java语句
        代码脚本还可以和表达式脚本一起组合使用，在jsp页面上输出数据
--%>
<%
    int i = 23;
    if (i == 23) {
%>
<h1>i是23呐</h1>
<%
} else {
%>
<h1>i不是是23呐</h1>
<%
    }
%>
<%--代码脚本 for循环--%>
<%
    for (int j = 0; j < 10; j++) {
//        System.out.println(j);
    }
%>
<table border="1" cellspacing="0">
    <%
        for (int j = 0; j < 10; j++) {
    %>
    <tr>
        <td>第<%=j + 1%>行</td>
    </tr>
    <%
        }
    %>

</table>


<%--代码脚本 --%>
<%
    String username = request.getParameter("username");
    System.out.println("用户名的请求参数值是：" + username);
%>
<%--还可以由多个代码脚本组合完成一个java语句--%>
<% for (int j = 0; j < 10; j++) { %>
<%= j%><br>
<% } %>

这是a.jsp
</body>
</html>
