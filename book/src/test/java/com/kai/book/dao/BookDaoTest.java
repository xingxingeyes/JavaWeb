package com.kai.book.dao;

import com.kai.book.dao.impl.BookDaoImpl;
import com.kai.book.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/17
 **/
public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"阿里","作者",new BigDecimal(999),5,0,null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBookById() {
        bookDao.updateBookById((new Book(21,"阿里baba","作者",new BigDecimal(999),5,0,null)));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBookList() {
        bookDao.queryBookList().forEach(book -> {
            System.out.println(book);
        });
    }
}