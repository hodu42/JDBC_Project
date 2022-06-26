package database;

import java.sql.*;

public class InsertSubject {
    protected boolean insert(Connection con, int sbjId, String sbjName, int scId) {
        try {
            CallableStatement cstmt = con.prepareCall("{call insertSubject(?,?,?)}");
            cstmt.setInt(1, sbjId);
            cstmt.setString(2, sbjName);
            cstmt.setInt(3, scId);
            cstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
