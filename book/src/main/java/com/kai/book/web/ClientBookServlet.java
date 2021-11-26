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

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/21
 **/
public class ClientBookServlet extends BaseServlet{
    BookService bookService = new BookServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
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
        page.setUrl("client/bookServlet?action=page");
        // 3.保存Page对象到Request域中
        request.setAttribute("page", page);
        // 4.请求转发到 page/manager/index.jsp页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }

    /**
     * 处理分页业务
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取请求参数 pageNo 和 pageSize
        int pageNo = WebUtils.parseInt(request.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(request.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(request.getParameter("min"), 0);
        int max = WebUtils.parseInt(request.getParameter("max"), Integer.MAX_VALUE);
        // 2.调用BookService.page(pageNo, pageSize): Page对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);

        StringBuilder sb = new StringBuilder("client/bookServlet?action=pageByPrice");
        // 如果有最小价格的参数，追加到分页条的地址参数中
        if (request.getParameter("min") != null) {
            sb.append("&min=").append(request.getParameter("min"));
        }
        if (request.getParameter("max") != null) {
            sb.append("&max=").append(request.getParameter("max"));
        }
        page.setUrl(sb.toString());
        // 3.保存Page对象到Request域中
        request.setAttribute("page", page);
        // 4.请求转发到 page/manager/index.jsp页面
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }

}
