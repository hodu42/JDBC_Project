package database;

import oracle.jdbc.OracleTypes;

import java.sql.*;

public class ShowSignUp {
    protected String show(Connection con, int stdId) {
        StringBuilder sb = new StringBuilder();

        try {
            CallableStatement cstmt = con.prepareCall("{call showSignUp(?,?)}");
            cstmt.setInt(1, stdId);
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
            cstmt.execute();

            ResultSet rs = null;
            rs = (ResultSet)cstmt.getObject(2);
            while(rs.next()) {
                String subjectId = rs.getString("subjectId");
                int scId = rs.getInt("scId");
                String subjectName = rs.getString("subjectName");

                sb.append(subjectId + "-" + scId + " " + subjectName);
                sb.append("\n\n");
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

}
