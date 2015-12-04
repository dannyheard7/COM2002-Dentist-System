package com2002.db;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
     private static Connection conn = null;  
     
     public static Connection getConnection() {
         if (conn == null)  {  
             try {
                 Class.forName("com.mysql.jdbc.Driver");
                 conn = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/team013", "team013", "96d980a0");
             } catch(Exception e){
                 System.out.println(e.toString());
             }
              
         }
         
         return conn;
     }
  
}
