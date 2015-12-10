package com2002.models;

import com2002.db.Database;

import java.math.BigDecimal;
import java.sql.*;


public class Treatment {

    private int treatmentID;
    private BigDecimal cost;
    private String name;
    private Connection conn;


    public Treatment(int treatmentID){
        treatmentByID(treatmentID);
    }

    public Treatment(String name, BigDecimal cost) {
        create(name, cost);
    }

    /**
     * Creates a new patient record in the database
     */
    private boolean create(String name, BigDecimal cost){
        this.name = name;
        this.cost = cost;
        conn = Database.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO Treatment (name, "
                            + "cost) VALUES ( ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1, name);
            stmt.setBigDecimal(2, cost);

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) { this.treatmentID = rs.getInt(1);}

        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
            Database.closeStatement(conn, stmt);
        }

        return true;
    }

    /**
     * Load the patient given a Patient's ID number
     * @param id - the id of the patient
     */
    private boolean treatmentByID(int id) {
        PreparedStatement stmt = null;
        conn = Database.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT * FROM Treatment WHERE treatmentID = ? LIMIT 1");

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                this.treatmentID = rs.getInt("treatmentID");
                this.name = rs.getString("name");
                this.cost = rs.getBigDecimal("cost");

            }
        } catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
                Database.closeStatement(conn, stmt);
        }

        return true;
    }


    // Basic get methods.
    public String getName() {
        return name;
    }
    public BigDecimal getCost() {
        return cost;
    }
    public int getTreatmentID() {
        return treatmentID;
    }


}
