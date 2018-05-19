package com.zhang.thread.ThreadLocal.DBThreadLocal;

import org.omg.CORBA.CODESET_INCOMPATIBLE;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 功能说明: 自己写一个事务，二条sql语句，执行与回滚   <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/5/19 20:57<br>
 * <br>
 */
public class ProductServiceImpl implements ProductService {

    private static final String UODATE_SQL = "";

    private static final String INSERT_SQL = "";

    @Override
    public void updateProductPrice(long productId, int price) {
        try {
            Connection conn = DBUtil.getConnection();
            conn.setAutoCommit(false); //关闭自动提交事务，（开启事务）

            updateProduct(conn,UODATE_SQL,1,1);
            insertLog(conn,INSERT_SQL,"");
            conn.commit();    //提交事务
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection();
        }
    }

    public void updateProduct(Connection connection,String updateSql,long productId,int productPrice) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
        preparedStatement.setInt(1,productPrice);
        preparedStatement.setLong(2,productId);
        int rows = preparedStatement.executeUpdate();
        if (rows != 0){
            System.out.println("Update product success");
        }
    }

    public void insertLog(Connection connection,String insetSql,String logDescription) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(insetSql);
        preparedStatement.setString(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        preparedStatement.setString(2,logDescription);
        int rows = preparedStatement.executeUpdate();
        if (rows != 0){
            System.out.println("Insert log success");
        }
    }


}
