<%@ page import="com.kai.pojo.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: kai.lv
  Date: 2021/11/12
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    Person person = new Person();
    person.setName("普拉斯");
    person.setPhones(new String[]{"2134234","345346","567567"});
    List<String> list = new ArrayList<>();
    list.add("北京");
    list.add("上海");
    list.add("广州");
    list.add("深圳");
    person.setCities(list);
    Map<String, Object> map = new HashMap<>();
    map.put("key1", "value1");
    map.put("key2", "value2");
    map.put("key3", "value3");
    map.put("key4", "value4");
    person.setMap(map);
    pageContext.setAttribute("p",person);

%>

    输出Person:${p}<br>
    输出Person的name属性:${p.name}<br>
    输出Person的phones数组属性值:${p.phones[2]}
    输出Person的cities集合中的元素值:${p.cities}<br>
    输出Person的cities集合中下标是2的元素值:${p.cities[2]}<br>
    输出Person的map集合:${p.map}<br>
    输出Person的map集合的key2的value值:${p.map.key2}<br>
    输出Person的map集合的key2的value值:${p.map.key2}<br>
    输出Person的age值:${p.age}<br>


</body>
</html>
