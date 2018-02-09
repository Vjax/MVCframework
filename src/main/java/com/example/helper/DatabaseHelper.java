package com.example.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseHelper.class);

    public static final String driver = ConfigHelper.getJdbcDriver();
    public static final String url = ConfigHelper.getJdbcUrl();
    public static final String name = ConfigHelper.getJdbcUsername();
    public static final String password = ConfigHelper.getJdbcPassword();

    private static ThreadLocal<Connection> connContainer = new ThreadLocal<Connection>();

    /**
     * 获取连接
     */
    public static Connection getConnection(){
        Connection conn =connContainer.get();
        try {
            if (conn == null){
                Class.forName(driver);
                conn = DriverManager.getConnection(url,name,password);
            }
        }catch (Exception e){
            LOGGER.error("get connection failure");
            throw new RuntimeException(e);
        }finally {
            connContainer.set(conn);
        }
        return conn;
    }

    /**
     * 关闭连接
     */
    public static void closeConnection(){
        Connection conn = connContainer.get();
        try {
            if (conn != null){
                conn.close();
            }
        }catch (Exception e){
            LOGGER.error("close connection failure",e);
            throw new RuntimeException(e);
        }finally {
            connContainer.remove();
        }
    }

    /**
     * 开启事务
     */
    public static void beginTransaction(){
        Connection conn = getConnection();
        if (conn != null){
            try{
                conn.setAutoCommit(false);
            }catch (SQLException e){
                LOGGER.error("begin transaction failure",e);
                throw new RuntimeException(e);
            }finally {
                connContainer.set(conn);
            }
        }
    }

    /**
     * 提交事务
     */
    public static void commitTransaction(){
        Connection conn = getConnection();
        if (conn != null){
            try {
                conn.commit();
                conn.close();
            }catch (SQLException e){
                LOGGER.error("commit transaction failure",e);
                throw new RuntimeException(e);
            }finally {
                connContainer.remove();
            }
        }
    }

    /**
     * 回滚事务
     */
    public static void rollbackTransaction(){
        Connection conn = getConnection();
        if (conn != null){
            try {
                conn.rollback();
                conn.close();
            }catch (SQLException e){
                LOGGER.error("rollback transaction failure",e);
                throw new RuntimeException(e);
            }finally {
                connContainer.remove();
            }
        }
    }
}
