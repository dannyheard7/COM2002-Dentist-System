package com2002.models;

import com2002.db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Appointment {
    
    private int id, staffID, patientID;
    private Date startTime, endTime;
    private Connection conn;

    public Appointment(int id) {
        conn = Database.getConnection();
        load(id);
    }
    
    public Appointment(int patientID, Date startTime, Date endTime, int staffID) {
        conn = Database.getConnection();
        create(patientID, startTime, endTime, staffID);
    }
    
    /**
    * Creates a new appointment record in the database
    */
    // TODO: load if appointment already exists
    private boolean create(int patientID, Date startTime, Date endTime, int staffID){
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
    private boolean load(int id) {
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
    
    /** 
     * Returns an array list of appointments on a specified date
     */
    private static ArrayList getOnDate(Date date) {
        Connection conn = Database.getConnection();
        
        ArrayList list = new ArrayList();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("SELECT appointmentID FROM Appointment WHERE DATE(startDate) = ?");
            
            stmt.setDate(1, new java.sql.Date(date.getTime()));
            ResultSet rs = stmt.executeQuery();  
           
            while(rs.next()) {
                list.add(new Appointment(rs.getInt("appointmentID")));
            }
        } catch(SQLException e) {
            System.out.println(e.toString());
        }  finally {
            try {
                if (stmt != null) { stmt.close();}
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
	}
        
        return list;
    }
            
}
