package com2002.models;

import com2002.db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Address {

    private int houseNo;
    private String street, city, district, postcode;

    public Address(int houseNo, String postcode) {
        load(houseNo, postcode);
    }

    public Address(int houseNo, String street, String city, String district, String postcode) {
        this.houseNo = 0;
        load(houseNo, postcode);

        // First check if the address to create already exists
        if (this.houseNo == 0){
            create(houseNo, street, city, district, postcode);
        }
    }

    private boolean load(int houseNo, String postcode) {
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("SELECT * FROM Address WHERE houseNo = ? AND LOWER(postcode) = ? LIMIT 1");
            stmt.setInt(1, houseNo);
            stmt.setString(2, postcode.toLowerCase());
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                this.houseNo = houseNo;
                this.street = rs.getString("street");
                this.city = rs.getString("city");
                this.district = rs.getString("district");;
                this.postcode = postcode;
            }

        } catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
            Database.closeStatement(conn, stmt);
	}

        return true;
    }

    /**
    * Creates a new address record in the database
    */
    private boolean create(int houseNo, String street, String city, String district, String postcode){
        Connection conn = Database.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO Address (houseNo, street, "
                    + "city, district, postcode) VALUES (?, ?, ?, ?, ?)");

            postcode = postcode.replace(" ", "");
            
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
            Database.closeStatement(conn, stmt);
	}

        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
        this.district = district;
        this.postcode = postcode;

        return true;
    }

    public int getHouseNo() { return houseNo; }

    public String getStreet() { return street; }

    public String getCity() { return city; }

    public String getDistrict() { return district; }

    public String getPostcode() { return postcode; }

    @Override
    public boolean equals(Object other){
        if((other == null) || (getClass() != other.getClass())){
            return false;
        } else {
            Address otherAddr = (Address) other;
            return houseNo == otherAddr.getHouseNo() && postcode.equals(otherAddr.getPostcode());
        }
    }
}
