package database;

import oracle.jdbc.OracleTypes;

import java.sql.*;

public class ShowDistributionAttendance {
    protected String show(Connection con, int sbjId, int scId) {
        StringBuilder sb = new StringBuilder();
        try {
            CallableStatement cstmt = con.prepareCall("{call showDistributionAttendance(?,?,?)}");
            cstmt.setInt(1, sbjId);
            cstmt.setInt(2, scId);
            cstmt.registerOutParameter(3, OracleTypes.CURSOR);
            cstmt.execute();

            ResultSet rs = null;
            rs = (ResultSet)cstmt.getObject(3);
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
