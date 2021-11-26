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

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    static {
        Properties properties = new Properties();
        try {
            // 读取 jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            // 从该文件中加载数据
            properties.load(inputStream);
            // 创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
            System.out.println(dataSource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 获取数据库连接池中的连接
     *
     * @return
     */
    public static Connection getConnection() {
        Connection conn = conns.get();

        if (conn == null) {
            try {
                conn = dataSource.getConnection(); // 从数据库连接池中获取连接
                conns.set(conn); // 保存到ThreadLocal对象中，供jbdc操作
                conn.setAutoCommit(false); // 设置为手动管理事务
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 提交事务，并关闭释放连接
     */
    public static void commitAndClose() {
        Connection connection = conns.get();
        if (connection != null) { // 如果不等于null，说明之前使用过连接操作过数据路
            try {
                connection.commit(); // 提交事务
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close(); // 关闭连接，释放资源
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        // 一定要执行remove操作，否则就会出错（因为tomcat服务器底层使用了线程池技术）
        conns.remove();
    }

    /**
     * 回滚事务，并关闭释放连接
     */
    public static void rollbackAndClose() {
        Connection connection = conns.get();
        if (connection != null) { // 如果不等于null，说明之前使用过连接操作过数据路
            try {
                connection.rollback(); // 回滚事务
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close(); // 关闭连接，释放资源
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        // 一定要执行remove操作，否则就会出错（因为tomcat服务器底层使用了线程池技术）
        conns.remove();
    }
}
