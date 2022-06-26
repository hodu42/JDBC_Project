package database;

import java.sql.*;

public class InsertSignUp {
    protected boolean insert(Connection con, int stdId, int scId, int sbjId, String grade) {
        try {
            CallableStatement cstmt = con.prepareCall("{call insertSignUp(?,?,?,?)}");
            cstmt.setInt(1, stdId);
            cstmt.setInt(2, scId);
            cstmt.setInt(3, sbjId);
            cstmt.setString(4, grade);
            cstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
