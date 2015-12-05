package com2002.models;

import com2002.db.Database;

import java.sql.*;

/**
 * Created by HarryH on 04/12/2015.
 */


public class PatientPlan {

    // TODO IMPLEMENT UPDATE METHOD FOR DATA IN THE TABLE

    private int patientID, remainCheckups, remainHygiene, remainTreatments;
    private String planName;
    private Date renewDate;
    private Connection conn;

    public PatientPlan(int id) {
        conn = Database.getConnection();
        patientPlanByID(id);
    }

    public PatientPlan(int patientID, String planName, int remainCheckups, int remainHygiene, int remainTreatments,
                       Date renewDate) {
        conn = Database.getConnection();
        create(patientID, planName, remainCheckups, remainHygiene, remainTreatments, renewDate);
    }

    /**
     * Creates a new patient plan record in the database
     */
    private boolean create(int patientID, String planName, int remainCheckups, int remainHygiene, int remainTreatments,
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

    /**
     * Load the patient plan given a Patient's ID number
     * @param id - the id of the patient
     */
    private boolean patientPlanByID(int id) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("SELECT * FROM PatientPlan WHERE patientID = ?");

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                this.patientID = rs.getInt("patientID");
                this.planName = rs.getString("planName");
                this.remainCheckups = rs.getInt("remainingCheckUps");
                this.remainHygiene = rs.getInt("remainingHygiene");
                this.remainTreatments = rs.getInt("remainingTreatments");
                this.renewDate = rs.getDate("renewDate");

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

        // TODO arraylist of patients on each plan - based on plan name.

        return true;
    }


    // Basic get methods.
    public int getPatientID() {return patientID;}
    public String getPlanName() {return planName;}
    public int getRemainCheckups() {return remainCheckups;}
    public int getRemainHygiene() {return remainHygiene;}
    public int getRemainTreatments() {return remainTreatments;}
    public Date renewDate() {return renewDate;}



}
