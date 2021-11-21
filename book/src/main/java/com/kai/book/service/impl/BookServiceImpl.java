package com.kai.book.service.impl;

import com.kai.book.dao.BookDao;
import com.kai.book.dao.impl.BookDaoImpl;
import com.kai.book.pojo.Book;
import com.kai.book.pojo.Page;
import com.kai.book.service.BookService;

import java.util.List;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/18
 **/
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBookById(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBookList();
    }

    @Override
    public Page page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();
        // 设置当前页数量
        page.setPageSize(pageSize);
        // 求总记录数
        int pageTotalCount = bookDao.queryForPageTotalCount();
        // 求总页码
        int pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal++;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);

        // 设置当前页码
        page.setPageNo(pageNo);
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);

        int begin = (page.getPageNo() - 1) * pageSize;
        // 求当前页数据
        List<Book> items = bookDao.queryForPageItems(begin, pageSize);
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();
        // 设置当前页数量
        page.setPageSize(pageSize);
        // 求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min, max);
        // 求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal++;
        }
        // 设置总页码
        page.setPageTotal(pageTotal);

        // 设置当前页码
        page.setPageNo(pageNo);
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);

        Integer begin = (page.getPageNo() - 1) * pageSize;
        // 求当前页数据
        List<Book> items = bookDao.queryForPageItemsByPrice(begin, pageSize, min, max);
        page.setItems(items);

        return page;
    }
}
