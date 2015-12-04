package com2002.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;

import com2002.db.Database;

public class Appointment {
    
    private int id, staffID, patientID;
    private Date startTime, endTime;
    private Connection conn;

    public Appointment() {
        conn = Database.getConnection();
    }
    
    /**
    * Creates a new appointment record in the database
    */
    public boolean create(int patientID, Date startTime, Date endTime, int staffID){
        this.patientID = patientID;
        this.staffID = staffID;
        this.startTime = startTime;
        this.endTime = endTime;
        
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("INSERT INTO Appointment (startTime, "
                    + "endTime, staffID, patientID) VALUES (?, ?, ?, ?)", 
                    PreparedStatement.RETURN_GENERATED_KEYS);
            
            stmt.setDate(1, new java.sql.Date(startTime.getTime()));
            stmt.setDate(2, new java.sql.Date(endTime.getTime()));
            stmt.setInt(3, staffID);
            stmt.setInt(4, patientID);
            
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) { this.id = rs.getInt(1); }
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
    
    /** 
     * Load the appointment given an id
     * @param id - the id of the appointment being loaded
     */
    public boolean load(int id) {
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM appointments WHERE appointmentID = ?");
          
            stmt.setInt(1, id);          
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) { 
                this.id = rs.getInt("appointmentID"); 
                this.startTime = rs.getDate("startTime");
                this.endTime = rs.getDate("endTime");
                this.staffID = rs.getInt("staffID");
                this.patientID = rs.getInt("patientID");
            }
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
    
    public int getID() {
        return this.id;
    }
    
    public Date getStartTime() {
        return startTime;
    }
    
    public Date getEndTime() {
        return endTime;
    }
            
}