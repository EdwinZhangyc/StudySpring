package com.spring.one.chapterOne.InitSpring.boilerplateCode;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JDBC手写最初版
 */
public class TestJDBC {

    public static void main (String[] args) {

    }

    public List<Map<String, Object>> selectT (String sql, Object[] objs) {

        String driverClass = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521";
        String user = "scott";
        String pass = "tiger";

        Connection conn = null;
        PreparedStatement pps = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        List<Map<String, Object>> lists = new ArrayList<Map<String, Object>> ();

        try {

            Class.forName(driverClass);
            conn = DriverManager.getConnection (url, user, pass);
            pps = conn.prepareStatement (sql);
            if (null != objs) {

                for (int i=0;i<objs.length;i++) {

                    pps.setObject(i, objs[i+1]);
                }
            }
            rs = pps.executeQuery();
            rsmd = rs.getMetaData();

            while (rs.next()) {
                Map<String, Object> map = new HashMap<String, Object> ();
                for (int i=0;i<rsmd.getColumnCount();i++) {
                   map.put(rsmd.getColumnName (i+1), rs.getObject(i+1));
                }
                lists.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != rs) rs.close();
                if (null != pps) pps.close();
                if (null != conn) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lists;

    }

}