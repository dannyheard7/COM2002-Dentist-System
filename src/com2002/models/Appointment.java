package com2002.models;

import com2002.db.Database;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Appointment {
    
    private int id, staffID, patientID, patientSeen;
    private Date startTime, endTime;

    public Appointment(int id) {
        load(id);
    }
   
    public Appointment(Patient patient, Date startTime, Date endTime, Staff staff) {
        create(patient, startTime, endTime, staff);
    }

    public Appointment(Date startTime, Date endTime, Staff staff) {
        create(startTime, endTime, staff);
    }
    
    /**
    * Creates a new appointment record in the database
    */
    private boolean create(Patient patient, Date startTime, Date endTime, Staff staff){
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;
        
        if (checkOverlap(patient, startTime, endTime, staff)) {
            return false;
        }    
        
        try {
            stmt = conn.prepareStatement("INSERT INTO Appointment (startTime, "
                    + "endTime, staffID, patientID, patientSeen) VALUES (?, ?, ?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            stmt.setObject(1, sdf.format(startTime));
            stmt.setObject(2, sdf.format(endTime));
            stmt.setInt(3, staff.getId());
            stmt.setInt(4, patient.getPatientID());
            stmt.setInt(5, 0);
            
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) { this.id = rs.getInt(1); }
        } catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
            Database.closeStatement(conn, stmt);
	}
        
        this.patientID = patient.getPatientID();
        this.staffID = staff.getId();
        this.startTime = startTime;
        this.endTime = endTime;
        
        return true;
    }

    /**
     * Creates an appointment with no patient
     */
    private boolean create(Date startTime, Date endTime, Staff staff){
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;

        if (checkOverlap(new Patient(0), startTime, endTime, staff)) {
            return false;
        }
        
        try {
            stmt = conn.prepareStatement("INSERT INTO Appointment (startTime, endTime, staffID) VALUES (?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            
            SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            stmt.setObject(1, sdf.format(startTime));
            stmt.setObject(2, sdf.format(endTime));
            stmt.setInt(3, staff.getId());

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
        this.staffID = staff.getId();
        this.startTime = startTime;
        this.endTime = endTime;
        
        return true;
    }
    
    /**
     * Checks if a given start and end datetime overlaps any other appointment for a staff member
    */
    public boolean checkOverlap(Patient patient, Date startTime, Date endTime, Staff staff) {
        for (Appointment a : Appointment.getAppointmentsOnDate(startTime)) {
            boolean overlaps = false;
            
            if (startTime.after(a.getStartTime()) && startTime.before(a.getEndTime())) {
                overlaps = true;
            } else if (endTime.after(a.getStartTime()) && endTime.before(a.getEndTime())) {
                overlaps = true;
            } else if (a.getStartTime().after(startTime) && a.getStartTime().before(endTime)) {
                overlaps = true;              
            } else if (a.getEndTime().after(startTime) && a.getEndTime().before(endTime)) {
                overlaps = true;
            } 
            
            if (overlaps && a.getStaff().getId() == staff.getId()) {
                return true;
            } else if (overlaps && a.getPatient().getPatientID() == getID()) {
                return true;
            }    
        }
        
        return false;
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
                this.startTime = rs.getTimestamp("startTime");
                this.endTime = rs.getTimestamp("endTime");
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
            stmt = conn.prepareStatement("DELETE FROM Treatment WHERE appointmentID = ?");
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
    public void addTreatment(String name, BigDecimal cost) {
        new Treatment(this, name, cost);
    }
    
    /**
     * Returns an array list of treatments associated with this appointment
     */
    public ArrayList<Treatment> getTreatments() {
        ArrayList<Treatment> treatments = new ArrayList<>();
        
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("SELECT name FROM Treatment WHERE appointmentID = ?");

            stmt.setInt(1, this.id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                treatments.add(new Treatment(this, rs.getString("name")));
            }
        } catch(SQLException e) {
            System.out.println(e.toString());
        }  finally {
            Database.closeStatement(conn, stmt);
        }
        
        return treatments;
    }
    
    /**
     * Returns an array list of the unpaid treatments associated with this appointment
     */
    public ArrayList<Treatment> getUnpaidTreatments() {
        ArrayList<Treatment> treatments = new ArrayList<>();
        
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("SELECT name FROM Treatment WHERE appointmentID = ? AND paid = 0");

            stmt.setInt(1, this.id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                treatments.add(new Treatment(this, rs.getString("name")));
            }
        } catch(SQLException e) {
            System.out.println(e.toString());
        }  finally {
            Database.closeStatement(conn, stmt);
        }
        
        return treatments;
    }
    
    /**
     * Appointment objects are equal if they have the same id
     */
    @Override
    public boolean equals(Object other){
        if((other == null) || (getClass() != other.getClass())){
            return false;
        } else {
            Appointment otherApp = (Appointment) other;
            return id == otherApp.getID();
        }
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
     * Updates the patientSeen column in the table
     */
    public boolean updatePatientSeen(Boolean b){
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("UPDATE Appointment SET patientSeen = ? "
                    + "WHERE appointmentID = ?");
            stmt.setBoolean(1, b);
            stmt.setInt(2, id);

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
     * Returns an array list of appointments on a specified date for a specified staff member
     */
    public static ArrayList<Appointment> getAppointmentsOnDate(Date date, Staff staff) {
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;

        ArrayList<Appointment> list = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT appointmentID FROM Appointment WHERE DATE(startTime) = ? AND staffID = ?");

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
     * Returns an array list of a specified patient's appointments for a given staff member
     */
    public static ArrayList<Appointment> findPatientsAppointments(Patient patient, String staff ){
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;
        ArrayList<Staff> lis = Staff.getStaffWithPosition(staff);
        int staffID = (lis.get(0)).getId();

        ArrayList<Appointment> list = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("SELECT appointmentID FROM Appointment WHERE patientID = ? AND partnerID = ?");

            stmt.setInt(1, patient.getPatientID());
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
    
    /**
     * Returns an array list of a specified patient's appointments
     */
    public static ArrayList<Appointment> findPatientsAppointments(Patient patient){
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;

        ArrayList<Appointment> list = new ArrayList<>();
        try {
            stmt = conn.prepareStatement("SELECT appointmentID FROM Appointment WHERE patientID = ?");

            stmt.setInt(1, patient.getPatientID());
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
