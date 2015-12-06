package com2002.db;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
     private static Connection conn = null;  
     
     public static Connection getConnection() {
         try {
            if (conn == null || conn.isClosed())  {

                 Class.forName("com.mysql.jdbc.Driver");
                 // TODO should this not just be a static string that is called so we can control the connections to the db in each method?
                 // we are never closing our connections
                 conn = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team013", "team013", "96d980a0");
            }
         } catch(Exception e){
             System.out.println(e.toString());
         }
         
         return conn;
     }
  
}
