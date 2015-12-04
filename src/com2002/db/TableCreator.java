package com2002.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class TableCreator {

//    public static String patientID;
//    public static String title;
//    public static String forename;
//    public static String surname;
//    public static String doB;
//    public static String contactNo;
//    public static int remainingCheckUps;
//    public static int remainingHygene;
//    public static int remainingTreatments;
//    public static String renewDate;
    private static String teamURL = "jdbc:mysql://stusql.dcs.shef.ac.uk/team013";
    private static String teamUserName = "team013" ;
    private static String teamPassword = "96d980a0";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            dropAll();
            createSchema();
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }
    
    /**
     * Creates the database schema
     */
    public static void createSchema() {
        try {
            Connection con = Database.getConnection();
            Statement stmt = con.createStatement(); // create from open connection

            String createPatientTable = "CREATE TABLE IF NOT EXISTS Patient " +
                    "(patientID INTEGER NOT NULL AUTO_INCREMENT, " +
                    " title VARCHAR(10), " +
                    " forename VARCHAR(40), " +
                    " surname VARCHAR(40), " +
                    " doB VARCHAR(9), " +
                    " contactNo VARCHAR(30), " +
                    " PRIMARY KEY ( patientID ))";
            
            String createPlanTable = "CREATE TABLE IF NOT EXISTS Plan (" +
                "  planID INT NOT NULL AUTO_INCREMENT," +
                "  name VARCHAR(30) NOT NULL," +
                "  monthlyCost DECIMAL(4,2) NOT NULL," +
                "  checkUpCount INT NOT NULL," +
                "  hygieneCount INT NOT NULL," +
                "  treatmentCount INT NOT NULL," +
                "  PRIMARY KEY (planId)" +
                ")";

            String createPatientPlanTable = "CREATE TABLE IF NOT EXISTS PatientPlan " +
                    "(patientID INTEGER not NULL, " +
                    " planID INTEGER not NULL, " +
                    " remainingCheckUps INTEGER, " +
                    " remainingHygiene INTEGER, " +
                    " remainingTreatments INTEGER, " +
                    " renewDate VARCHAR(9), " +
                    " FOREIGN KEY (patientID) REFERENCES Patient(patientID), " +
                    " PRIMARY KEY ( planID ))";
            
            String createStaffTable = "CREATE TABLE IF NOT EXISTS Staff (" +
                "  staffID INT NOT NULL AUTO_INCREMENT," +
                "  position varchar(10) NOT NULL," +
                "  PRIMARY KEY (staffID)" +
                ")";
            
            String createAppointmentTable = "CREATE TABLE IF NOT EXISTS Appointment (" +
                "  appointmentID INT NOT NULL AUTO_INCREMENT, " +
                "  startTime DATETIME NOT NULL," +
                "  endTime DATETIME NOT NULL," +
                "  staffID INT NOT NULL," +
                "  patientID INT," +
                "  PRIMARY KEY (appointmentID)," +
                "  FOREIGN KEY (patientID) REFERENCES Patient(patientID)," +
                "  FOREIGN KEY (staffID) REFERENCES Staff(staffID)" +
                ")";

            String createTreatmentTable = "CREATE TABLE IF NOT EXISTS Treatment " +
                    "(treatmentID INTEGER not NULL AUTO_INCREMENT, " +
                    " name VARCHAR(30), " +
                    " cost DECIMAL, " +
                    " length INTEGER, " +
                    " PRIMARY KEY ( treatmentID ))";

            String createAppointTreatmentTable = "CREATE TABLE IF NOT EXISTS  AppointmentTreatment " +
                    "(treatmentID INTEGER not NULL, " +
                    " appointmentID INTEGER not NULL, " +
                    " PRIMARY KEY (treatmentID, appointmentID), " +
                    " FOREIGN KEY (treatmentID) REFERENCES Treatment(treatmentID), " +
                    " FOREIGN KEY ( appointmentID ) REFERENCES Appointment(appointmentID))";
            
            String createAddressTable = "CREATE TABLE IF NOT EXISTS Address (" +
                "houseNo INT NOT NULL," +
                "  street VARCHAR(30), " +
                "  city VARCHAR(30), " +
                "  district VARCHAR(30), " +
                "  postcode VARCHAR(8) NOT NULL," +
                "  PRIMARY KEY (houseNo, postcode)" +
                ")";
            
            String createPatientAddressTable = "CREATE TABLE IF NOT EXISTS PatientAddress ( " +
                "  patientID INT NOT NULL," +
                "  houseNo INT NOT NULL," +
                "  postcode VARCHAR(8) NOT NULL," +
                "  PRIMARY KEY (patientID, houseNo, postcode)," +
                "  FOREIGN KEY (patientID) REFERENCES Patient(patientID)," +
                "  FOREIGN KEY (houseNo, postcode) REFERENCES Address(houseNo, postcode)" +
                ")";      

            stmt.executeUpdate(createPatientTable);
            stmt.executeUpdate(createPlanTable);
            stmt.executeUpdate(createPatientPlanTable);
            stmt.executeUpdate(createStaffTable);
            stmt.executeUpdate(createAppointmentTable);
            stmt.executeUpdate(createTreatmentTable);
            stmt.executeUpdate(createAppointTreatmentTable);
            stmt.executeUpdate(createAddressTable);
            stmt.executeUpdate(createPatientAddressTable);
           
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    /** 
     * Drops all tables in the database for schema changes
     */
    public static void dropAll() {
        try {
            Connection con =  Database.getConnection();
            Statement stmt = con.createStatement(); // create from open connection
        
            String clear = "DROP TABLE IF EXISTS PatientAddress,Address,"
                    + "PatientPlan,Plan,AppointmentTreatment,Treatment,"
                    + "Appointment,Staff,Patient;"; 
        stmt.executeUpdate(clear);
        } catch(SQLException e) {
            System.out.println(e.toString());
        }
    }
    
   
}