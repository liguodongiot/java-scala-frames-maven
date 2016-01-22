package com.lgd.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.*;
import java.util.*;


/**
 * Created by liguodong on 2016/1/20.
 */

public class JdbcUtil {

    static Properties pros = null; //可以帮助和处理资源文件中的信息
    private static Logger logger = LoggerFactory.getLogger(JdbcUtil.class);


    static{//加载 JdbcUtil 类的时候调用一次
        pros = new Properties();
        try {
            logger.info("资源配置。。。");
            pros.load(Thread.currentThread().getContextClassLoader().
                    getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Connection getMysqlConn()
    {
        try {
            logger.info("连接Mysql," + pros.getProperty("mysqlDriver")+ ":"
                            + pros.getProperty("mysqlURL")+ ":"
                            + pros.getProperty("mysqlUser")+ ":"
                            + pros.getProperty("mysqlPwd")
                        );

            Class.forName(pros.getProperty("mysqlDriver"));
            return DriverManager.getConnection(pros.getProperty("mysqlURL"),
                    pros.getProperty("mysqlUser"),pros.getProperty("mysqlPwd"));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }




    /**
     * 执行更新操作
     *
     * @param conn      连接
     * @param ps        定义sql语句的执行对象
     * @param sql       sql语句
     * @param params    执行参数
     * @return 执行结果
     * @throws SQLException
     */
    public static boolean updateByPreparedStatement(Connection conn,
                                                    PreparedStatement ps,
                                                    String sql,
                                                    List<?> params)
            throws SQLException {
        boolean flag = false;
        int result = -1;// 表示当用户执行添加删除和修改的时候所影响数据库的行数

        //
        ps = conn.prepareStatement(sql);
        int index = 1;
        // 填充sql语句中的占位符
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                ps.setObject(index++, params.get(i));
            }
        }
        result = ps.executeUpdate();
        flag = result > 0 ? true : false;
        return flag;
    }

    /**
     * 执行查询操作
     *
     * @param conn      连接
     * @param ps        定义sql语句的执行对象
     * @param rs        定义查询返回的结果集合
     * @param sql       sql语句
     * @param params    执行参数
     * @return
     * @throws SQLException
     */
    public static List<Map<String, Object>> findResult(Connection conn,
                                                       PreparedStatement ps,
                                                       ResultSet rs,
                                                       String sql,
                                                       List<?> params)
            throws SQLException {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        int index = 1;
        ps = conn.prepareStatement(sql);
        if (params != null && !params.isEmpty()) {
            for (int i = 0; i < params.size(); i++) {
                ps.setObject(index++, params.get(i));
            }
        }

        rs = ps.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        int cols_len = metaData.getColumnCount();
        while (rs.next()) {
            Map<String, Object> map = new HashMap<String, Object>();
            for (int i = 0; i < cols_len; i++) {
                String cols_name = metaData.getColumnName(i + 1);
                Object cols_value = rs.getObject(cols_name);
                if (cols_value == null) {
                    cols_value = "";
                }
                map.put(cols_name, cols_value);
            }
            list.add(map);
        }
        return list;
    }



    public static void close(Connection conn)
    {
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement stat,Connection conn)
    {
        if(stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs, Statement stat,Connection conn)
    {
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        logger.info("关闭数据库连接。");
    }

}
