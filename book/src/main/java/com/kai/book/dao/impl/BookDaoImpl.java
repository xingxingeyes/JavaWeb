package com.kai.book.dao.impl;

import com.kai.book.dao.BookDao;
import com.kai.book.pojo.Book;

import java.util.List;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/17
 **/
public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) values(?,?,?,?,?,?,?)";
        return update(sql, book.getId(),book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getstock(),book.getImg_path());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql,id);
    }

    @Override
    public int updateBookById(Book book) {
        String sql = "update t_book  set `name`=? , `author`=? , `price`=? , `sales`=? , `stock`=? , `img_path`=? where id=?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getstock(),book.getImg_path(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select * from t_book where id=?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBookList() {
        String sql = "select * from t_book";
        return queryForList(Book.class, sql);
    }
}
