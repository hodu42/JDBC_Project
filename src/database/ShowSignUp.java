package database;

import java.sql.*;

public class ShowSignUp {
    protected String show(Connection con, int stdId) {
        StringBuilder sb = new StringBuilder();
        String query = ("");

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                String subjectId = rs.getString("subjectId");
                int scId = rs.getInt("scId");
                String subjectName = rs.getString("subjectName");

                sb.append(subjectId + "-" + scId + " " + subjectName);
                sb.append("\n\n");
            }
            rs.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

}
