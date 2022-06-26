package database;

import oracle.jdbc.OracleTypes;

import java.sql.*;

public class ShowSubject {
    protected void show(Connection con) {
        try {
            CallableStatement cstmt = con.prepareCall("{call showsubject(?)}");

            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.execute();

            ResultSet rs = null;
            rs = (ResultSet)cstmt.getObject(1);
            while(rs.next()) {
                String subjectId = rs.getString("subjectId");
                String subjectName = rs.getString("subjectName");

                System.out.println(subjectId + " " + subjectName);
                System.out.println();
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
