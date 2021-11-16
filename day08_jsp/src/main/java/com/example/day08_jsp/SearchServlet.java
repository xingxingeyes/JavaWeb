package com.example.day08_jsp;

import com.example.day08_jsp.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/11
 **/
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数
        // 发sql语句查血学生的信息
        //  使用for循环生成查询到的数据做模拟
        List<Student> list = new ArrayList<>();
        int t =18;
        for (int i = 0; i < 10; i++) {
            list.add(new Student(i, "name" + 1, t+i, "phone" + i));
        }
        // 保存查询到的结果（学生信息）到request域中
        request.setAttribute("stuList",list);
        // 请求转发到showStudent.jsp页面
        request.getRequestDispatcher("/test/showStudent.jsp").forward(request,response);


    }

}
