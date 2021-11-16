package com.kai.book.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @description:
 * @author: kai.lv
 * @date: 2021/11/10
 **/
public class JdbcUtils {

    private  static DruidDataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            // 读取 jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从该文件中加载数据
            properties.load(inputStream);
            // 创建数据库连接池
            dataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
            System.out.println(dataSource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 获取数据库连接池中的连接
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭连接，放回数据库连接池
     * @param conn
     */
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }



}
