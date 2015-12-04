package com2002.models;

import com2002.db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by HarryH on 04/12/2015.
 */
public class Patient {

    private int patientID;
    private String title, forename, surname, contactNo;
    private Date dateOfBirth;
    private Connection conn;

    public Patient() {
        conn = Database.getConnection();
    }

    /**
     * Creates a new address record in the database
     */
    public boolean create(int patientID, String title, String forename, String surname, Date dob, String contactNo){
        this.patientID = patientID;
        this.title = title;
        this.forename = forename;
        this.surname = surname;
        this.dateOfBirth = dob;
        this.contactNo = contactNo;

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO Patient (patientID, title, "
                    + "forename, surname, doB, contactNo) VALUES (?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, patientID);
            stmt.setString(2, title);
            stmt.setString(3, forename);
            stmt.setString(4, surname);
            stmt.setDate(5, new java.sql.Date(dob.getTime())); // what is with this??
            stmt.setString(6, contactNo);

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
