package main;

import database.DAO;

import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String userId = "sys as sysdba";
        String pwd = "Qktek0014-";

        DAO dao = new DAO("", url, userId, pwd);


    }
}
