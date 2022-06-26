package database;

import oracle.jdbc.internal.OracleTypes;

import java.sql.*;

public class ShowSubjectAttendance {
    protected String show(Connection con, int sbjId) {
        StringBuilder sb = new StringBuilder();

        try {
            CallableStatement cstmt = con.prepareCall("{call showSubjectAttendance(?,?)}");
            cstmt.setInt(1, sbjId);
            cstmt.registerOutParameter(2, OracleTypes.CURSOR);
            cstmt.execute();

            ResultSet rs = null;
            rs = (ResultSet)cstmt.getObject(2);
            while(rs.next()) {
                String id = rs.getString("id");

                sb.append(id);
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
