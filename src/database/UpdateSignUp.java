package database;

import java.sql.*;

public class UpdateSignUp {
    protected void update(Connection con, int stdId, int newScId, int newSbjId, int oldSbjId) {
        try {
            CallableStatement cstmt = con.prepareCall("{call updateSignUp(?,?,?,?)}");
            cstmt.setInt(1, stdId);
            cstmt.setInt(2, newScId);
            cstmt.setInt(3, newSbjId);
            cstmt.setInt(4, oldSbjId);
            cstmt.executeUpdate();

            cstmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
