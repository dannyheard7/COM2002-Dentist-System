package com2002.models;

import com2002.db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

/**
 * Created by HarryH on 04/12/2015.
 */
public class Patient {

    // TODO IMPLEMENT UPDATE METHOD FOR DATA IN THE TABLE

    private int patientID;
    private String title, forename, surname, contactNo;
    private Date dateOfBirth;
    private Connection conn;


    public Patient (int patientID){
        conn = Database.getConnection();
        patientByID(patientID);
    }
    public Patient(String title, String forename, String surname, Date dob, String contactNo) {
        conn = Database.getConnection();
        create(title, forename, surname, dob, contactNo);
    }

    /**
     * Creates a new patient record in the database
     */
    private boolean create(String title, String forename, String surname, Date dob, String contactNo){
        this.title = title;
        this.forename = forename;
        this.surname = surname;
        this.dateOfBirth = dob;
        this.contactNo = contactNo;

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO Patient (title, "
                    + "forename, surname, doB, contactNo) VALUES ( ?, ?, ?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1, title);
            stmt.setString(2, forename);
            stmt.setString(3, surname);
            stmt.setDate(4, dob); // what is with this??
            stmt.setString(5, contactNo);

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) { this.patientID = rs.getInt(1);}

        } catch (SQLException e) {
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
     * Load the patient given a Patient's ID number
     * @param id - the id of the patient
     */
    private boolean patientByID(int id) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("SELECT * FROM Patient WHERE patientID = ?");

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                this.patientID = rs.getInt("patientID");
                this.title = rs.getString("title");
                this.forename = rs.getString("forename");
                this.surname = rs.getString("surname");
                this.dateOfBirth = rs.getDate("doB");
                this.contactNo = rs.getString("contactNo");

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
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public String getContactNo() {return contactNo;}


}
