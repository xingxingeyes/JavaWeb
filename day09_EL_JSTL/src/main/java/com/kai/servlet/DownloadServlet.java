package com.kai.servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/15
 **/
public class DownloadServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取要下载的文件名
        String downloadFileName = "1.jpg";
        // 2.读取要下载的文件内容(通过ServletContext对象可以读取)
        ServletContext context = getServletContext();
        // 获取下载的文件类型
        String mimeType = context.getMimeType("/file/" + downloadFileName);
        System.out.println("下载的文件类型：" + mimeType);
        // 3.再回传前，通过响应头告诉客户端返回的数据类型
        resp.setContentType(mimeType);
        // 4.还要告诉客户端收到的数据适用于下载使用（还是使用响应头）
        // Content-Disposition 响应头, 表示收到的数据怎么处理
        // filename= 表示要下载的文件名字,可以与下载的原文件名不同，相当于改名
        // url编码是把汉字转化为%xx%xx%xx的格式

        if (req.getHeader("User-Agent").contains("Firefox")) {
            // 如果是火狐浏览器使用Base64编码
            resp.setHeader("Content-Disposition", "attachment; fileName==?UTF-8?B?" + new BASE64Encoder().encode("中国.jpg".getBytes(StandardCharsets.UTF_8)) + "?=");
        } else {
            // 如果不是火狐浏览器，是IE或谷歌浏览器用URL编码
            resp.setHeader("Content-Disposition", "attachment; fileName=" + URLEncoder.encode("中国.jpg", "UTF-8"));
        }

        /**
         * 斜杠被服务器解析表示地址为http://ip:port/工程名/ 映射 到代码的web目录
         */
        InputStream resourceAsStream = context.getResourceAsStream("/file/" + downloadFileName);

        OutputStream outputStream = resp.getOutputStream();
        // 读取输入流中全部的数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream, outputStream);
        // 3.
    }
}
