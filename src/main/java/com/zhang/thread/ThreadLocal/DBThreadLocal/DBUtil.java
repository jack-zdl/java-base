package com.zhang.thread.ThreadLocal.DBThreadLocal;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 功能说明:    <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/5/18 23:13<br>
 * <br>
 */
public class DBUtil {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql//localhost:3306/demo";
    private static final String username = "root";
    private static final String password = "root";

    /**
     * 这个是所有的数据库连接都用一个，所以导致会有线程之间相互干扰
     */
    private static Connection conn = null;


    // 获取连接
    public static Connection getConnection(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    // 关闭连接
    public static void closeConnection(){
        try {
            if (conn != null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
