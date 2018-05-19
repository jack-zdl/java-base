package com.zhang.thread.ThreadLocal.DBThreadLocal;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 功能说明:    <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/5/19 21:00<br>
 * <br>
 */
public class DBUtilThreadLocal {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql//localhost:3306/demo";
    private static final String username = "root";
    private static final String password = "root";


    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    // 获取连接
    public static Connection getConnection(){
        Connection conn = connectionThreadLocal.get();
        try {
            if(conn == null){
                Class.forName(driver);
                conn = DriverManager.getConnection(url,username,password);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connectionThreadLocal.set(conn);
        }
        return conn;
    }

    // 关闭连接
    public static void closeConnection(){
        Connection conn = connectionThreadLocal.get();
        try {
            if (conn != null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connectionThreadLocal.remove();
        }
    }
}
