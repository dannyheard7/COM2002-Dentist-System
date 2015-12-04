package com2002.models;

import java.sql.*;

/**
 * Created by HarryH on 04/12/2015.
 */
public class AppointmentTreatment {

    private Connection conn;

    public AppointmentTreatment(Connection con){
        conn = con;
    }

    // SQL table details.
    private static String tableName = "Appointment-Treatment";
    private static String appointmentID = "appointmentID";
    private static String treatmentID = "treatmentID";


    public static int getAppointmentID(int TreatmentID){return 0;}
    public static int getTreatmentID(int AppointmentID){return 0;}


}
