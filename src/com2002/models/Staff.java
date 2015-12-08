package com2002.models;

import com2002.db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Staff {
    
    private int id;
    private String position;

    public Staff(String position) {
        create(position);
    }

    public Staff(int id) {
        load(id);
    }

    /**
     * Creates a new staff record in the database
     */
    private boolean create(String position){
        this.position = position;

        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO Staff (position) VALUES (?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1, position);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) { this.id = rs.getInt(1); }
        } catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
            Database.closeStatement(conn, stmt);
        }

        return true;
    }

    /**
     * Load the staff member given an id
     * @param id - the id of the staff member being loaded
     */
    private boolean load(int id) {
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("SELECT * FROM Staff WHERE staffID = ?");

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                this.id = rs.getInt("staffID");
                this.position = rs.getString("position");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            Database.closeStatement(conn, stmt);
        }

        return true;
    }

    public int getId() { return id; }

    public String getPosition() { return position; }

    /**
     * Returns an array list of appointments for this staff member on the specified date
     */
    public ArrayList<Appointment> getAppointmentsOnDate(Date date) {
        return Appointment.getAppointmentsOnDate(date, this);
    }

    /**
     * Returns an array list of staff with a specified position e.g. 'dentist', 'hygienist'
     */
    public static ArrayList<Staff> getStaffWithPosition(String position) {
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;

        ArrayList<Staff> list = new ArrayList<>();

        try {
            stmt = conn.prepareStatement("SELECT staffID FROM Staff WHERE position = ?");

            stmt.setString(1, position);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                list.add(new Staff(rs.getInt("staffID")));
            }
        } catch(SQLException e) {
            System.out.println(e.toString());
        }  finally {
            Database.closeStatement(conn, stmt);
        }

        return list;
    }

}
