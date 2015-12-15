package com2002.db;

import com2002.models.*;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

public class TableCreator {

    public static void main(String[] args) {
        dropAll();
        createSchema();
        testData();
    }
    
    /**
     * Creates the database schema
     */
    public static void createSchema() {
        Connection conn = Database.getConnection();
        Statement stmt = null;

        try {
            stmt = conn.createStatement();

            String createPatientTable = "CREATE TABLE IF NOT EXISTS Patient " +
                "(patientID INT NOT NULL AUTO_INCREMENT, " +
                " title VARCHAR(10), " +
                " forename VARCHAR(40), " +
                " surname VARCHAR(40), " +
                " doB DATE, " +
                " contactNo VARCHAR(30), " +
                " PRIMARY KEY ( patientID ))";
            
            String createPlanTable = "CREATE TABLE IF NOT EXISTS Plan (" +
                "  name VARCHAR(30) NOT NULL," +
                "  monthlyCost DECIMAL(4,2) NOT NULL," +
                "  checkUpCount INT NOT NULL," +
                "  hygieneCount INT NOT NULL," +
                "  treatmentCount INT NOT NULL," +
                "  PRIMARY KEY (name), " +
                "  UNIQUE KEY ( name ) "+
                ")";

            String createPatientPlanTable = "CREATE TABLE IF NOT EXISTS PatientPlan " +
                "(patientID INT not NULL, " +
                " planName VARCHAR(30) not NULL, " +
                " remainingTreatments INT, " +
                    "remainingCheckUps INT, " +
                    "remainingHygiene INT, " +
                " renewDate DATE NOT NULL, " +
                " FOREIGN KEY (patientID) REFERENCES Patient(patientID), " +
                " FOREIGN KEY (planName) REFERENCES Plan(name), " +
                " PRIMARY KEY ( planName, patientID ), "+
                    "UNIQUE KEY ( patientID ))";
            
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
                    " patientSeen TINYINT(1)," +
                "  PRIMARY KEY (appointmentID)," +
                "  FOREIGN KEY (patientID) REFERENCES Patient(patientID)," +
                "  FOREIGN KEY (staffID) REFERENCES Staff(staffID)," +
                "  UNIQUE KEY (startTime, staffID), " +
                "  UNIQUE KEY (startTime, patientID) " +
                ")";
            
            String createTreatmentTable = "CREATE TABLE IF NOT EXISTS  Treatment " +
                "(name VARCHAR(30), " +
                " cost DECIMAL(5, 2)," +
                " appointmentID INTEGER not NULL, " +
                " paid TINYINT(1) NOT NULL DEFAULT 0, " +
                " PRIMARY KEY (appointmentID, name), " +
                " FOREIGN KEY ( appointmentID ) REFERENCES Appointment(appointmentID))";
            
            String createAddressTable = "CREATE TABLE IF NOT EXISTS Address (" +
                "houseNo INT(6) NOT NULL," +
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
            stmt.executeUpdate(createAddressTable);
            stmt.executeUpdate(createPatientAddressTable);
           
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } finally {
            Database.closeStatement(conn, stmt);
        }
    }
    
    /** 
     * Drops all tables in the database for schema changes
     */
    public static void dropAll() {
        Connection con =  Database.getConnection();
        Statement stmt = null;

        try {
            stmt = con.createStatement(); // create from open connection
        
            String clear = "DROP TABLE IF EXISTS PatientAddress,Address,"
                    + "PatientPlan,Plan,AppointmentTreatment,Treatment,"
                    + "Appointment,Staff,Patient;"; 
            stmt.executeUpdate(clear);
        } catch(SQLException e) {
            System.out.println(e.toString());
        } finally {
            Database.closeStatement(con, stmt);
        }
    }

    /**
     * Creates entries in the tables, so that the GUI actually shows things.
     */
    public static void testData(){

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 2);
        cal.add(Calendar.HOUR,-3);
        Date twoDaysStart = cal.getTime();
        cal.add(Calendar.MINUTE, 20);
        Date twoDaysEnd = cal.getTime();
        Calendar cal2 = Calendar.getInstance();
        Date plusYear = cal2.getTime();
        cal.add(Calendar.YEAR,1);
        Patient p = new Patient("Ms","Beth","Lum", new Date(),"07504988541");
        Patient a = new Patient("Dr","John","Smith", new Date(),"01912401786");
        new Address(40,"Street","Plymouth","South","pl157dy");
        new Address(7,"Lesbury Road","Newcastle","North","ne65lb");
        a.addAddress(new Address(7, "ne65lb"));
        p.addAddress(new Address(40, "pl157dy"));
        Appointment app = new Appointment(p,twoDaysStart,twoDaysEnd,new Staff("Dentist"));
        new Staff("Hygienist");
        app.addTreatment("Tooth Extraction", new BigDecimal(150.10));
        new Plan("NHS Free", new BigDecimal(0.0), 0, 0, 0);
        new Plan("For Ballers", new BigDecimal(0.0), 3, 2, 1);

        new PatientPlan(p.getPatientID(),"NHS Free", plusYear);
//        new PatientPlan(a.getPatientID(), "For Ballers", plusYear);

//        Patient p = (new Patient(3));
//        System.out.println(p.getForename()+" "+ p.getSurname() +" "+p.getAddress().getPostcode() +" "+ p.getDateOfBirth().toString());

    }
    
}
