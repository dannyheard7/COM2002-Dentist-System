package com2002;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import com2002.db.Database;

public class SQL {

    public static void main(String[] args) {

        try {
            Connection con = Database.getConnection();
           
            DatabaseMetaData md = con.getMetaData();
            ResultSet rs = md.getTables(null, null, "%", null);
            while (rs.next()) {
                System.out.println(rs.getString(3));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
    
   
}