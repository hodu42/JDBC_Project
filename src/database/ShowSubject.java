package database;

import oracle.jdbc.OracleTypes;

import java.sql.*;

public class ShowSubject {
    protected String show(Connection con) {
        StringBuilder sb = new StringBuilder();
        String query = "SELECT * FROM Subject";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            sb.append("Subject Id\tSubject Name\n");

            while(rs.next()) {
                String subjectId = rs.getString("subjectId");
                String subjectName = rs.getString("subjectName");

                sb.append(subjectId + "\t" + subjectName);
                sb.append("\n\n");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}
