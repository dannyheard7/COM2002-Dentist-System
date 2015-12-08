package com2002.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
     private static Connection conn = null;  
     
     public static Connection getConnection() {
         try {
            if (conn == null || conn.isClosed())  {

                 Class.forName("com.mysql.jdbc.Driver");
                 // we are never closing our connections
                 conn = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team013", "team013", "96d980a0");
            }
         } catch(Exception e){
             System.out.println(e.toString());
         }
         
         return conn;
     }

    public static void closeStatement(Connection conn, PreparedStatement stmt) {
        try {
            if (stmt != null) { stmt.close();}
            if (conn != null) { conn.close(); }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
  
}
