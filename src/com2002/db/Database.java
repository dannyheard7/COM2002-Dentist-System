package com2002.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
     
     public static Connection getConnection() {
         Connection conn = null;

         try {

            Class.forName("com.mysql.jdbc.Driver");
             // we are never closing our connections
             conn = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team013", "team013", "96d980a0");
         } catch(Exception e){
             System.out.println(e.toString());
         }
         
         return conn;
     }

    public static void closeStatement(Connection conn, Statement stmt) {
        try {
            if (stmt != null) { stmt.close();}
            if (conn != null) { conn.close(); }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
  
}
