package com.kai.book.service;

import com.kai.book.pojo.Book;

import java.util.List;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/18
 **/
public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();




}
