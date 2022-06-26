package main;

import database.DAO;

import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        DAO dao = createDAO();

        Database db = new Database(dao);
        db.run();
    }

    private static DAO createDAO() {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String userId = "c##madang";
        String pwd = "madang";

        return new DAO("", url, userId, pwd);
    }
}
