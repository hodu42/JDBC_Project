package database;

import java.sql.*;

public class DAO {
    protected Connection con;

    public DAO(String driver, String url, String userId, String pwd) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 로드 성공");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("데이터베이스 연결 준비 ...");
            con = DriverManager.getConnection(url, userId, pwd);
            System.out.println("데이터베이스 연결 성공");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
