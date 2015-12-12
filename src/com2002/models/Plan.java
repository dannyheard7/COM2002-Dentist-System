package com2002.models;

import com2002.db.Database;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Plan {

    private String name;
    private BigDecimal monthlyCost;
    private int checkUps, hygieneCount, treatments;

    public Plan(String planName) {
        load(planName);
    }

    public Plan(String planName, BigDecimal monthlyCost, int checkUps, int hygieneCount, int treatments) {
        create(planName, monthlyCost, checkUps, hygieneCount, treatments);
    }

    private boolean create(String planName, BigDecimal monthlyCost, int checkUps, int hygieneCount, int treatments) {
        this.name = planName;
        this.monthlyCost = monthlyCost;
        this.checkUps = checkUps;
        this.hygieneCount = hygieneCount;
        this.treatments = treatments;

        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO Plan (name, monthlyCost, checkUpCount, hygieneCount," +
                    "treatmentCount) VALUES (?, ?, ?, ?, ?)");

            stmt.setString(1, planName);
            stmt.setBigDecimal(2, monthlyCost);
            stmt.setInt(3, checkUps);
            stmt.setInt(4, hygieneCount);
            stmt.setInt(5, treatments);

            stmt.executeUpdate();
        } catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
            Database.closeStatement(conn, stmt);
        }

        return true;
    }

    private boolean load(String planName) {
      Connection conn = Database.getConnection();
      PreparedStatement stmt = null;

      try {
         stmt = conn.prepareStatement("SELECT * FROM Plan WHERE name = ? LIMIT 1");

         stmt.setString(1, planName);
         ResultSet rs = stmt.executeQuery();

         if (rs.next()) {
             this.name = rs.getString("name");
             this.monthlyCost = rs.getBigDecimal("monthlyCost");
             this.checkUps = rs.getInt("checkUpCount");
             this.hygieneCount = rs.getInt("hygieneCount");
             this.treatments = rs.getInt("treatmentCount");
         }
      } catch (SQLException e) {
         System.out.println(e.toString());
         return false;
      } finally {
         Database.closeStatement(conn, stmt);
      }

      return true;
   }

    public String getName() { return this.name; }
    public BigDecimal getMonthlyCost() { return this.monthlyCost; }
    public int getCheckUps() { return this.checkUps; }
    public int getHygieneCount() { return this.hygieneCount; }
    public int getTreatments() { return this.treatments; }
    
    public static ArrayList<Plan> getAllPlans() {
        ArrayList<Plan> plans = new ArrayList<>();
        
        Connection conn = Database.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("SELECT name FROM Plan");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                plans.add(new Plan(rs.getString("name")));
            }
        } catch(SQLException e) {
            System.out.println(e.toString());
        }  finally {
            Database.closeStatement(conn, stmt);
        }
        
        return plans;
    }
}
