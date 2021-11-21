package com.kai.book.service;

import com.kai.book.pojo.Book;
import com.kai.book.pojo.Page;
import com.kai.book.service.BookService;
import com.kai.book.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/18
 **/
public class BookServiceTest {

    BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"阿里","作者",new BigDecimal(999),5,0,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"阿里巴巴","作者马云",new BigDecimal(999),5,0,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        bookService.queryBooks().forEach(book -> {
            System.out.println(book);
        });
    }

    @Test
    public void page() {
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }
    @Test
    public void pageByPrice() {
        System.out.println(bookService.pageByPrice(1, Page.PAGE_SIZE, 10, 50));
    }
}