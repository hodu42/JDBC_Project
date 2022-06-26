package database;

import java.sql.*;

public class ShowSignUp {
    protected String show(Connection con, int stdId) {
        StringBuilder sb = new StringBuilder();
        String query = ("SELECT subject.subjectid, signup.scid, subject.subjectname FROM SignUp, subject"
                + "WHERE signup.id = " + "stdId"
                + " AND signup.subjectid = subject.subjectid;");

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            sb.append("subjectId\t-scId\tsubjectName\n");
            while(rs.next()) {
                String subjectId = rs.getString("subjectId");
                int scId = rs.getInt("scId");
                String subjectName = rs.getString("subjectName");

                sb.append(subjectId + "\t-" + scId + "\t" + subjectName);
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
