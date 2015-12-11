package com2002;

import com2002.db.Database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

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