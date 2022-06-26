package database;

import java.sql.*;

public class ShowDistributionAttendance {
    protected String show(Connection con, int sbjId, int scId) {
        StringBuilder sb = new StringBuilder();
        String query = ("SELECT id FROM signUp "
                + "WHERE "+ scId +" = signUp.scId "
                + "AND " + sbjId + " = signUp.sbjId");

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            sb.append("Student Id\n");
            while(rs.next()) {
                String id = rs.getString("id");

                sb.append(id);
                sb.append("\n\n");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

}
