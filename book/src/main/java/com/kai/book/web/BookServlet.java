package com.kai.book.web;

import com.kai.book.pojo.Book;
import com.kai.book.pojo.Page;
import com.kai.book.service.BookService;
import com.kai.book.service.impl.BookServiceImpl;
import com.kai.book.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/18
 **/
public class BookServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    private BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 0);
        pageNo+=1;

        //  1. 获取请求参数==封装成book对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        //  2.调用BookService.addBook()保存图书
        bookService.addBook(book);
        /**
         * 3.跳转到图书页面
         *  跳转的斜杠表示到工程名下
         *               /manager/bookServlet?action=list
         *  使用跳转表单会重复提交：
         *      当用户提交完请求，浏览器会记录下最后一次请求的全部信息。当用户按下功能键F5,就会发起浏览器记录的最后一次请求，这样就重复提交了
         */
        // request.getRequestDispatcher("/manager/bookServlet?action=list").forward(request,response);
        /**
         * 重定向是两次请求，浏览器记录的是最后一次的查询请求，所以就不用重复提交了
         *      重定向的斜杠表示到端口
         *             request.getScheme() 它可以获取请求的协议
         *             request.getServerName() 获取请求的服务器的ip地址
         *             requset.getServerPort() 获取请求服务器的端口号
         *             request.getConetxtPath() 获取当前工程路径
         *             request.getMethod() 获取请求方式 get/post
         *             request.getRemoteHost() 获取客户端的ip地址
         *             session.getId() 获取回话的唯一标识
         */
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);

    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求的参数id
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        // 2.调用bookService.deleteBookById();删除图书
        bookService.deleteBookById(id);
        // 3.重定向会图书列表管理页面
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page&pageNo="+request.getParameter("pageNo"));
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求参数 封装成Book对象
        Book book = WebUtils.copyParamToBean(request.getParameterMap(), new Book());
        // 2.修改图书
        bookService.updateBook(book);
        // 3.重定向到图书列表页面
        //    地址：request.getContextPath()+ /工程名/manager/bookServlet?action=list
        response.sendRedirect(request.getContextPath()+"/manager/bookServlet?action=page&pageNo="+request.getParameter("pageNo"));

    }
    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取图书编号
        int id = WebUtils.parseInt(request.getParameter("id"), 0);
        // 2.得到修改的图书信息
        Book book = bookService.queryBookById(id);
        // 3.把图书保存到Request域中
        request.setAttribute("book",book);
        // 4.请求转发到 /pages/manager/book_edit.jsp页面
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取图书列表
        List<Book> books = bookService.queryBooks();
        // 2.将图书列表保存到request域中
        request.setAttribute("books", books);
        // 3.转发到manager.jsp页面中
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);

    }

    /**
     * 处理分页业务
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        // 2.调用BookService.page(pageNo, pageSize): Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("manager/bookServlet?action=page");
        // 3.保存Page对象到Request域中
        request.setAttribute("page", page);
        // 4.请求转发到 page/manager/book_manager.jsp页面
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);
    }






}
