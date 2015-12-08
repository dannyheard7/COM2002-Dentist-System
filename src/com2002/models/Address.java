package com2002.models;

import com2002.db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Address {
    
    private int houseNo;
    private String street, city, district, postcode;
    private Connection conn;

    public Address() {
        conn = Database.getConnection();
    }
    
    /**
    * Creates a new address record in the database
    */
    // TODO: load if address already exists
    private boolean create(int houseNo, String street, String city, String district, String postcode){
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
        this.district = district;
        this.postcode = postcode;
        
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("INSERT INTO Address (houseNo, street, "
                    + "city, district, postcode) VALUES (?, ?, ?, ?, ?)");
            
            stmt.setInt(1, houseNo);
            stmt.setString(2, street);
            stmt.setString(3, city);
            stmt.setString(4, district);
            stmt.setString(5, postcode);
            
            stmt.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
            try {
                if (stmt != null) { stmt.close();}
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
	    }
        
        return true;
    }
    
    public int getHouseNo() { return houseNo; }
    
    public String getStreet() { return street; }
    
    public String getCity() { return city; }
    
    public String getDistrict() { return district; }
    
    public String getPostcode() { return postcode; }
}
