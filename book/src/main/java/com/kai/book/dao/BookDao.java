package com.kai.book.dao;

import com.kai.book.pojo.Book;

import java.util.List;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/17
 **/
public interface BookDao {

    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBookById(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBookList();

    public Integer queryForPageTotalCount();

    public List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(Integer begin, int pageSize, int min, int max);
}
