package com.ymbj.jdbc;

import java.sql.*;

/**
 * 代码来自：
 *https://www.cnblogs.com/happyhacking/p/4306752.html
 */
public class JdbcTest {
    public static void main(String[] args) {
        Connection conn = null;  //局部变量没有默认的初始化，类的成员变量才有
        Statement stat = null;
        ResultSet rs = null;

        try {
            //1.注册数据库驱动
            //--由于mysql在Driver类的实现中自己注册了一次，而我们又注册了一次，于是会导致mysql驱动被注册两次
            //--创建mysqldeDriver对象时，导致了程序和具体的mysql驱动绑死在了一起，在切换数据库时需要修改代码
            //DriverManager.registerDriver(new Driver());
            //反射
            // Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "123456");
            stat = conn.createStatement();
            rs = stat.executeQuery("select * from user");
            //5.遍历结果集获取查询对象
            while(rs.next()){
                String name = rs.getString("name");
                System.out.println(name);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源//异常处理
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    rs = null;
                }
            }
            if (rs != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    rs = null;
                }
            }
            if (rs != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } finally {
                    rs = null;
                }
            }
        }
    }
}
