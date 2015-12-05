package com2002.models;

import com2002.db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Staff {
    
    private int id;
    private String position;
    private Connection conn;

    public Staff() {
        conn = Database.getConnection();
    }

    public Staff(String position) {
        conn = Database.getConnection();
        create(position);
    }

    public Staff(int id) {
        conn = Database.getConnection();
        load(id);
    }

    /**
     * Creates a new staff record in the database
     */
    public boolean create(String position){
        this.position = position;

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
            try {
                if (stmt != null) { stmt.close();}
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }

        return true;
    }

    /**
     * Load the staff member given an id
     * @param id - the id of the staff member being loaded
     */
    private boolean load(int id) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("SELECT * FROM Staff WHERE staffID = ?");

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                this.id = rs.getInt("staffID");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }

        return true;
    }

    public int getId() {
        return id;
    }
}
