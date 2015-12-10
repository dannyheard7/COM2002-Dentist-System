package com2002.models;

import com2002.db.Database;

import java.sql.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by HarryH on 04/12/2015.
 */

public class PatientPlan {

    // TODO IMPLEMENT UPDATE METHOD FOR DATA IN THE TABLE

    private int patientID, remainTreatments, remainCheckups, remainHygiene;
    private String planName;
    private Date renewDate;
    private Connection conn;

    public PatientPlan(int id) {
        patientPlanByID(id);
    }

    public PatientPlan(String planName){
        patientPlanByName(planName);
    }

    public PatientPlan(int patientID, String planName, Date renewDate) {
        create(patientID, planName, renewDate);
    }

    /**
     * Creates a new patient plan record in the database
     */
    private boolean create(int patientID, String planName,
                          Date renewDate){
        Plan p = new Plan(planName);
        this.patientID = patientID;
        this.planName = planName;
        this.renewDate = renewDate;
        this.remainCheckups = p.getCheckUps();
        this.remainHygiene = p.getHygieneCount();
        this.remainTreatments = p.getTreatments();
        conn = Database.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO PatientPlan (patientID, planName, "
                    + "remainingTreatments, remainingCheckUps, remainingHygiene, renewDate) VALUES (?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, patientID);
            stmt.setString(2, planName);
            stmt.setInt(3, remainTreatments);
            stmt.setInt(4, remainCheckups);
            stmt.setInt(5, remainHygiene);
            stmt.setDate(6, new java.sql.Date(renewDate.getTime()));

            stmt.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
            try {
                if (stmt != null) { stmt.close();}
                if (conn != null) {
                    conn.close();
                }
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
        conn = Database.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT * FROM PatientPlan WHERE patientID = ?");

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                this.patientID = rs.getInt("patientID");
                this.planName = rs.getString("planName");
                this.remainTreatments = rs.getInt("remainingTreatments");
                this.renewDate = rs.getDate("renewDate");
            }
        } catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
            Database.closeStatement(conn, stmt);
        }

        return true;
    }

    private boolean updateTreatments(){
        PreparedStatement stmt = null;
        conn = Database.getConnection();
        try{
            this.remainTreatments = getRemainTreatments()-1;
            stmt = conn.prepareStatement("UPDATE PatientPlan SET remainingTreatments="+(remainTreatments)+
                                        "WHERE PatientID="+getPatientID());
        } catch (SQLException e){
            System.out.println(e.toString());
            return false;
        } finally {
            Database.closeStatement(conn, stmt);
        }

        return true;
    }
    private boolean updateCheckUps(){


        return true;
    }
    private boolean updateHygiene(){


        return true;
    }

    // TODO arraylist of patients on each plan - based on plan name.
    private ArrayList patientPlanByName(String planName) {
        PreparedStatement stmt = null;
        conn = Database.getConnection();

        ArrayList lis = new ArrayList();

        try {
            stmt = conn.prepareStatement("SELECT * FROM PatientPlan WHERE patientID = ?");

            stmt.setString(1, planName);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                lis.add(new Patient(rs.getInt("patientID")));
            }
        } catch(SQLException e) {
            System.out.println(e.toString());
            return null;
        }  finally {
            Database.closeStatement(conn, stmt);
        }

        return lis;
    }


    // Basic get methods.
    public int getPatientID() {return patientID;}
    public String getPlanName() {return planName;}
    public int getRemainTreatments() {return remainTreatments;}
    public Date renewDate() {return renewDate;}



}
