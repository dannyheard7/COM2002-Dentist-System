package com2002.models;

import com2002.db.Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by HarryH on 04/12/2015.
 */


public class PatientPlan {

    // TODO IMPLEMENT UPDATE METHOD FOR DATA IN THE TABLE

    private int patientID, remainCheckups, remainHygiene, remainTreatments;
    private String planName;
    private Date renewDate;
    private Connection conn;

    public PatientPlan() {
        conn = Database.getConnection();
    }

    /**
     * Creates a new patient plan record in the database
     */
    public boolean create(int patientID, String planName, int remainCheckups, int remainHygiene, int remainTreatments,
                          Date renewDate){
        this.patientID = patientID;
        this.planName = planName;
        this.remainCheckups = remainCheckups;
        this.remainHygiene = remainHygiene;
        this.remainTreatments = remainTreatments;
        this.renewDate = renewDate;

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO PatientPlan (patientID, planName, "
                    + "remainingCheckUps, remainingHygiene, remainingTreatments, renewDate) VALUES (?, ?, ?, ?, ?)");

            stmt.setInt(1, patientID);
            stmt.setString(2, planName);
            stmt.setInt(3, remainCheckups);
            stmt.setInt(4, remainHygiene);
            stmt.setInt(5, remainTreatments);
            stmt.setDate(6, renewDate);

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

    public int getPatientID() {return patientID;}
    public String getPlanName() {return planName;}
    public int getRemainCheckups() {return remainCheckups;}
    public int getRemainHygiene() {return remainHygiene;}
    public int getRemainTreatments() {return remainTreatments;}
    public Date renewDate() {return renewDate;}



}
