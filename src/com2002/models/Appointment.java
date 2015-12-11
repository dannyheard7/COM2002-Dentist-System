package com2002.models;

import com2002.db.Database;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Appointment {
    
    private int id, staffID, patientID;
    private Date startTime, endTime;

    public Appointment(int id) {
        load(id);
    }
    
    public Appointment(int patientID, Date startTime, Date endTime, int staffID) {
        create(patientID, startTime, endTime, staffID);
    }

    public Appointment(Date startTime, Date endTime, int staffID) {
        create(startTime, endTime, staffID);
    }

    public Appointment(int patientID, int staffID){

    }
    
    /**
    * Creates a new appointment record in the database
    */
    private boolean create(int patientID, Date startTime, Date endTime, int staffID){
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("INSERT INTO Appointment (startTime, "
                    + "endTime, staffID, patientID) VALUES (?, ?, ?, ?)", 
                    PreparedStatement.RETURN_GENERATED_KEYS);

            SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            stmt.setObject(1, sdf.format(startTime));
            stmt.setObject(2, sdf.format(endTime));
            stmt.setInt(3, staffID);
            stmt.setInt(4, patientID);
            
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) { this.id = rs.getInt(1); }
        } catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
            Database.closeStatement(conn, stmt);
	}
        
        this.patientID = patientID;
        this.staffID = staffID;
        this.startTime = startTime;
        this.endTime = endTime;
        
        return true;
    }

    /**
     * Creates an appointment with no patient
     */
    private boolean create(Date startTime, Date endTime, int staffID){
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO Appointment (startTime, endTime, staffID) VALUES (?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            
            SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            stmt.setObject(1, sdf.format(startTime));
            stmt.setObject(2, sdf.format(endTime));
            stmt.setInt(3, staffID);

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) { this.id = rs.getInt(1); }
        } catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
            Database.closeStatement(conn, stmt);
        }
        
        this.patientID = 0;
        this.staffID = staffID;
        this.startTime = startTime;
        this.endTime = endTime;
        
        return true;
    }
    
    /** 
     * Load the appointment given an id
     * @param id - the id of the appointment being loaded
     */
    private boolean load(int id) {
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM Appointment WHERE appointmentID = ? LIMIT 1");
          
            stmt.setInt(1, id);          
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) { 
                this.id = rs.getInt("appointmentID"); 
                this.startTime = rs.getDate("startTime");
                this.endTime = rs.getDate("endTime");
                this.staffID = rs.getInt("staffID");

                this.patientID = rs.getInt("patientID");
                if (rs.wasNull()) {
                    // Patient column can be null
                    this.patientID = 0;
                }
            }
        } catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
            Database.closeStatement(conn, stmt);
	}
        
        return true;
    }
    
    public int getID() { return this.id; }
    
    public Date getStartTime() { return startTime; }
    
    public Date getEndTime() { return endTime; }

    public Patient getPatient() {
        if (this.patientID == 0) {
            return null;
        }

        return new Patient(this.patientID);
    }

    public Staff getStaff() { return new Staff(this.staffID); }

    /**
     * Cancels the appointment and all the related treatments
     * @return 1 if executed correctly otherwise 0
     */
    public boolean cancel() {
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;     

        try {  
            // May need to do a batch somehow
            stmt = conn.prepareStatement("DELETE FROM AppointmentTreatment WHERE appointmentID = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            
            stmt = conn.prepareStatement("DELETE FROM Appointment WHERE appointmentID = ?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
            this.id = this.staffID = this.patientID = 0;
            this.startTime = this.endTime = null;

            Database.closeStatement(conn, stmt);
        }

        return true;
    }
    
    /**
     * Adds a specified treatment to the appointment
     * @return boolean value representing result
     */
    public boolean addTreatment(Treatment t) {
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = conn.prepareStatement("INSERT INTO AppointmentTreatment ("
                    + "appointmentId, treatmentID) VALUES (?, ?)");
            
            stmt.setInt(1, id);
            stmt.setInt(2, t.getTreatmentID());
            
            stmt.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
            Database.closeStatement(conn, stmt);
	}
        
        return true;
    }
    
    /**
     * Returns an array list of treatments associated with this appointment
     */
    public ArrayList<Treatment> getTreatments() {
        ArrayList<Treatment> treatments = new ArrayList<>();
        
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("SELECT treatmentID FROM AppointmentTreatment"
                    + " WHERE appointmentID = ?");

            stmt.setInt(1, this.id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                treatments.add(new Treatment(rs.getInt("treatmentID")));
            }
        } catch(SQLException e) {
            System.out.println(e.toString());
        }  finally {
            Database.closeStatement(conn, stmt);
        }
        
        return treatments;
    }
    
    /** 
     * Returns an array list of appointments on a specified date
     */
    public static ArrayList<Appointment> getAppointmentsOnDate(Date date) {
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;

        ArrayList<Appointment> list = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT appointmentID FROM Appointment WHERE DATE(startTime) = ?");
            
            SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
            String dtString = sdf.format(date);
            Date dt = sdf.parse(dtString);

            stmt.setDate(1, new java.sql.Date(dt.getTime()));
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                list.add(new Appointment(rs.getInt("appointmentID")));
            }
        } catch(Exception e) {
            System.out.println(e.toString());
        }  finally {
            Database.closeStatement(conn, stmt);
        }

        return list;
    }

    /**
     * Returns an array list of appointments on a specified date for a specified staff member
     */
    public static ArrayList<Appointment> getAppointmentsOnDate(Date date, Staff staff) {
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;

        ArrayList<Appointment> list = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT appointmentID FROM Appointment WHERE DATE(startDate) = ? AND partnerID = ?");

            stmt.setDate(1, new java.sql.Date(date.getTime()));
            stmt.setInt(2, staff.getId());
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                list.add(new Appointment(rs.getInt("appointmentID")));
            }
        } catch(SQLException e) {
            System.out.println(e.toString());
        }  finally {
            Database.closeStatement(conn, stmt);
        }

        return list;
    }

    /**
     * Appointment objects are equal if they have the same id
     */
    public boolean equals(Object other){
        if((other == null) || (getClass() != other.getClass())){
            return false;
        } else {
            Appointment otherApp = (Appointment) other;
            return id == otherApp.getID();
        }
    }


    public static ArrayList<Appointment> findPatientsAppointments(int patientID, String staff ){
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;
        ArrayList<Staff> lis = Staff.getStaffWithPosition(staff);
        int staffID = (lis.get(0)).getId();

        ArrayList<Appointment> list = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("SELECT appointmentID FROM Appointment WHERE patientID = ? AND partnerID = ?");

            stmt.setInt(1, patientID);
            stmt.setInt(2, staffID);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                list.add(new Appointment(rs.getInt("appointmentID")));
            }
        } catch(SQLException e) {
            System.out.println(e.toString());
        }  finally {
            Database.closeStatement(conn, stmt);
        }

        return list;

    }

}
