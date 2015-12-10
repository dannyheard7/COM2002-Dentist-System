package com2002.models;

import com2002.db.Database;
import sun.java2d.pipe.SpanShapeRenderer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by HarryH on 04/12/2015.
 */
public class Patient {

    // TODO IMPLEMENT UPDATE METHOD FOR DATA IN THE TABLE

    private int patientID;
    private String title, forename, surname, contactNo;
    private SimpleDateFormat dateOfBirth;
    private Connection conn;


    public Patient (int patientID){
        patientByID(patientID);
    }

    public Patient(String title, String forename, String surname, SimpleDateFormat dob, String contactNo) {
        create(title, forename, surname, dob, contactNo);
    }

    public Patient(String forename, String surname, SimpleDateFormat dob){
        findPatients(forename, surname, dob);

    }

    /**
     * Creates a new patient record in the database
     */
    private boolean create(String title, String forename, String surname, SimpleDateFormat dob, String contactNo){
        this.title = title;
        this.forename = forename;
        this.surname = surname;
        this.dateOfBirth = dob;
        this.contactNo = contactNo;
        conn = Database.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO Patient (title, "
                    + "forename, surname, doB, contactNo) VALUES ( ?, ?, ?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
            String dt = sdf.format(dob);
            stmt.setString(1, title);
            stmt.setString(2, forename);
            stmt.setString(3, surname);
            stmt.setObject(4, dt); // what is with this??
            stmt.setString(5, contactNo);

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) { this.patientID = rs.getInt(1);}

        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
            Database.closeStatement(conn, stmt);
        }

        return true;
    }

    private ArrayList findPatients(String forename, String surname, SimpleDateFormat dob){
        this.forename = forename;
        this.surname = surname;
        this.dateOfBirth = dob;
        conn = Database.getConnection();
        PreparedStatement stmt = null;
        ArrayList lis = new ArrayList();

        try {
            stmt = conn.prepareStatement("SELECT * FROM Patient WHERE forename = ? and surname = ? and doB = ?");

            stmt.setString(1, forename);
            stmt.setString(2, surname);
            stmt.setString(3, dob.toString());
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                lis.add(new Patient(rs.getInt("patientID")));
            }
        } catch (SQLException e){
            System.out.println(e.toString());
            return null;
        } finally {
            Database.closeStatement(conn, stmt);
        }

        return lis;
    }

    /**
     * Load the patient given a Patient's ID number
     * @param id - the id of the patient
     */
    private boolean patientByID(int id) {
        PreparedStatement stmt = null;
        conn = Database.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT * FROM Patient WHERE patientID = ? LIMIT 1");

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                this.patientID = rs.getInt("patientID");
                this.title = rs.getString("title");
                this.forename = rs.getString("forename");
                this.surname = rs.getString("surname");
                this.dateOfBirth = new SimpleDateFormat(rs.getString("doB"));
                this.contactNo = rs.getString("contactNo");

            }
        } catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
            Database.closeStatement(conn, stmt);
        }

        return true;
    }

    // TODO decide another way to return a patient - how much is enough to uniquely identify them. So we can get the ID.....


    // Basic get methods.
    public int getPatientID() {
        return patientID;
    }
    public String getTitle() {
        return title;
    }
    public String getForename() {
        return forename;
    }
    public String getSurname() {
        return surname;
    }
    public SimpleDateFormat getDateOfBirth() {
        return dateOfBirth;
    }
    public String getContactNo() {return contactNo;}


}
