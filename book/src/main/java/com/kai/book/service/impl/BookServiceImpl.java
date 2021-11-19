package com.kai.book.service.impl;

import com.kai.book.dao.BookDao;
import com.kai.book.dao.impl.BookDaoImpl;
import com.kai.book.pojo.Book;
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
}
