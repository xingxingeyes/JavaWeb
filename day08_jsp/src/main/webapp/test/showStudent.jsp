<%@ page import="com.example.day08_jsp.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: kai.lv
  Date: 2021/11/11
  Time: 20:50
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
<%--jsp输出一个表格里有 20 个学生的信息， 个学生的信息，
表格包含学号 ， 姓名 ， 年龄 ， 电话 ， 操作 （ 删除 ， 修改 ）
的信息。
--%>
<%
//    List<Student> list = new ArrayList<>();
//    int t =18;
//    for (int i = 0; i < 10; i++) {
//        list.add(new Student(i, "name" + 1, t+i, "phone" + i));
//    }
    List<Student> list = (List<Student>)request.getAttribute("stuList");

%>
    <table>
        <thead>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>电话</td>
        <td>操作</td>
        </thead>
        <% for (int i = 0; i < list.size(); i++) { %>
        <tr>
            <td><%=list.get(i).getId()%></td>
            <td><%=list.get(i).getName()%></td>
            <td><%=list.get(i).getAge()%></td>
            <td><%=list.get(i).getPhone()%></td>
            <td>删除、修改</td>
        </tr>
        <% } %>
    </table>

</body>
</html>
