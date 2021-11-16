package com.kai.book.test;

import com.kai.book.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/10
 **/
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils() {
        for (int i = 0; i < 100; i++) {
            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn);
            JdbcUtils.close(conn);
            System.out.println(i);
        }

    }
}
