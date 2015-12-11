package com2002.models;

import com2002.db.Database;

import java.math.BigDecimal;
import java.sql.*;


public class Treatment {

    private int appointmentID;
    private BigDecimal cost;
    private boolean paid;
    private String name;


    public Treatment(String name, Appointment appointment){
        load(name, appointment);
    }

    public Treatment(Appointment appointment, String name, BigDecimal cost) {
        create(appointment, name, cost);
    }

    /**
     * Creates a new patient record in the database
     */
    private boolean create(Appointment appointment, String name, BigDecimal cost){
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO Treatment (name, cost "
                            + "appointmentID) VALUES (?, ?, ?)");

            stmt.setString(1, name);
            stmt.setBigDecimal(2, cost);
            stmt.setInt(3, appointment.getID());

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
            Database.closeStatement(conn, stmt);
        }

        this.name = name;
        this.cost = cost;
        this.paid = false;
        this.appointmentID = appointment.getID();

        return true;
    }

    /**
     * Load the patient given the treatment name and the appointment it belongs to
     * @param name - the name of the treatment
     */
    private boolean load(String name, Appointment appointment) {
        PreparedStatement stmt = null;
        Connection conn = Database.getConnection();
        try {
            stmt = conn.prepareStatement("SELECT * FROM Treatment WHERE name = ?"
                    + "AND appointmentID = ? LIMIT 1");

            stmt.setString(1, name);
            stmt.setInt(2, appointment.getID());
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                this.cost = rs.getBigDecimal("cost");
                this.paid = rs.getBoolean("paid");
            }
        } catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
            Database.closeStatement(conn, stmt);
        }

        return true;
    }

    // Basic get methods.
    public String getName() {
        return name;
    }
    public BigDecimal getCost() {
        return cost;
    }
    public Appointment getAppointment() {
        return new Appointment(appointmentID);
    }

    public boolean equals(Object other) {
        if((other == null) || (getClass() != other.getClass())){
            return false;
        } else {
            Treatment otherTreat = (Treatment) other;
            return appointmentID == otherTreat.getAppointment().getID() && name == otherTreat.getName();
        }
    }

    /**
     * Mark a given treatment as paid
     */
    public boolean pay() {
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("UPDATE AppointmentTreatment SET paid = 1 "
                    + "WHERE appointmentID = ? AND name= ?");

            stmt.setInt(1, appointmentID);
            stmt.setString(2, name);

            stmt.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
            Database.closeStatement(conn, stmt);
	}

        return true;
    }



}
