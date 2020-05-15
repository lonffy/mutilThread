package jdbc.prepare;

import org.junit.Test;

import java.sql.*;

public class T {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/ry?serverTimezone=GMT%2B8";
    private static String userName = "root";
    private static String passwd = "123456";

    public static void main(String[] args) {


    }

    @Test
    public void test2() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, passwd);
            Statement statement = conn.createStatement();
            String sqldet = "\"1\" or 1=1";
            ResultSet rs = statement.executeQuery("select * from sys_user where user_id=" + sqldet);
            while (rs.next()) {
                System.out.println(rs.getObject(1));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        Connection conn = null;
        PreparedStatement pstm = null;
        String sqldet = "\"1\" or 1=1";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, passwd);
            pstm = conn.prepareStatement("select * from sys_user where user_id=?");
            pstm.setString(1, sqldet);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getObject(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    /**
     * 开启服务端预编译
     */
    @Test
    public void test3() {
        Connection conn = null;
        PreparedStatement pstm = null;
        String sqldet = "1";
        url = "jdbc:mysql://localhost:3306/ry?serverTimezone=GMT%2B8&useServerPrepStmts=true";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, passwd);
            pstm = conn.prepareStatement("select * from sys_user where user_id=?");
            pstm.setString(1, sqldet);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getObject(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }



    /**
     * 测试ClientPreparedStatement 是否会使用服务端预编译 --> 不会, 因为日志中没有prepare语句
     */
    @Test
    public void test4() {
        String userId = "1";
        url = "jdbc:mysql://localhost:3306/ry?serverTimezone=GMT%2B8";
        try (
                Connection conn = DriverManager.getConnection(url, userName, passwd);
                PreparedStatement pstm = conn.prepareStatement("select login_name from sys_user where user_id=?");
        ) {
            Class<?> aClass = Class.forName(driver);
            pstm.setString(1, userId);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getObject(1));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试ClientPreparedStatement 开启缓存后, 是缓存到mysql服务端还是JDBC客户端的
     * 结论: 缓存在JDBC客户端的
     */
    @Test
    public void test5() throws Exception{
        url = "jdbc:mysql://localhost:3306/ry?serverTimezone=GMT%2B8&cachePrepStmts=true";
        Connection conn = DriverManager.getConnection(url, userName, passwd);
        for(int i=0;i<3;i++){
            PreparedStatement pstm = conn.prepareStatement("select login_name from sys_user where user_id=?");
            Class<?> aClass = Class.forName(driver);
            pstm.setString(1, String.valueOf(i));
            ResultSet rs = pstm.executeQuery();
            rs.close();
            pstm.close();
        }
    }

    /**
     * 测试ServerPreparedStatement 看看使用MySQL服务端时log是否输出prepare
     * 结论: 用的是MySQL的预编译功能
     */
    @Test
    public void test6() throws Exception{
        url = "jdbc:mysql://localhost:3306/ry?serverTimezone=GMT%2B8&useServerPrepStmts=true";
        Connection conn = DriverManager.getConnection(url, userName, passwd);
        for(int i=0;i<3;i++){
            PreparedStatement pstm = conn.prepareStatement("select login_name from sys_user where user_id=?");
            Class<?> aClass = Class.forName(driver);
            pstm.setString(1, String.valueOf(i));
            ResultSet rs = pstm.executeQuery();
            rs.close();
            pstm.close(); // 每次close后, 下次循环就不是原来的PreparedStatement, 所以服务端才会有3次PreparedStatement
        }


    }

    @Test
    public void test7() throws Exception{
        url = "jdbc:mysql://localhost:3306/ry?serverTimezone=GMT%2B8&useServerPrepStmts=true&cachePrepStmts=true";
        Connection conn = DriverManager.getConnection(url, userName, passwd);
        for(int i=0;i<3;i++){
            PreparedStatement pstm = conn.prepareStatement("select login_name from sys_user where user_id=?");
            Class<?> aClass = Class.forName(driver);
            pstm.setString(1, String.valueOf(i));
            ResultSet rs = pstm.executeQuery();
            rs.close();
            pstm.close();
            // 开启cachePrepStmts后, 每次close后, 会把PreparedStatement缓存起来,这样下次循环还是原来的, 所以不会有3次PreparedStatement
        }
    }


    /**
     * 开启服务端预编译, 并且直接调用serverPrepareStatement
     */
    @Test
    public void test8() {
        Connection conn = null;
        PreparedStatement pstm = null;
        String sqldet = "1";
        url = "jdbc:mysql://localhost:3306/ry?serverTimezone=GMT%2B8&useServerPrepStmts=true";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, passwd);
            pstm = conn.prepareStatement("select * from sys_user where user_id=?");
            pstm.setString(1, sqldet);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getObject(1));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
