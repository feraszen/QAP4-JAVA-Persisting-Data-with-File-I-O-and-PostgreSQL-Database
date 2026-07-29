package com.qap4.services;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.qap4.entities.Patient;

public class DatabaseService {

    private String url;
    private String user;
    private String password;

    public DatabaseService() {
        loadDatabaseConfig();
    }

    // Load DB config from db.properties
    private void loadDatabaseConfig() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
            Properties props = new Properties();
            props.load(input);

            url = props.getProperty("db.url");
            user = props.getProperty("db.user");
            password = props.getProperty("db.password");

        } catch (Exception e) {
            System.out.println("Error loading database configuration: " + e.getMessage());
        }
    }

    // Connect to PostgreSQL
    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // Insert a patient into the database
    public void savePatientToDatabase(Patient patient) {
        String sql = "INSERT INTO patients (patient_id, first_name, last_name, dob) VALUES (?, ?, ?, ?)";

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, patient.getPatientId());
            stmt.setString(2, patient.getPatientFirstName());
            stmt.setString(3, patient.getPatientLastName());
            stmt.setString(4, patient.getPatientDOB());

            stmt.executeUpdate();
            System.out.println("Patient saved to database successfully!");

        } catch (SQLException e) {
            System.out.println("Error saving patient to database: " + e.getMessage());
        }
    }

    // Read all patients from the database
    public List<Patient> readPatientsFromDatabase() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT patient_id, first_name, last_name, dob FROM patients";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("patient_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String dob = rs.getString("dob");

                patients.add(new Patient(id, firstName, lastName, dob));
            }

        } catch (SQLException e) {
            System.out.println("Error reading patients from database: " + e.getMessage());
        }

        return patients;
    }
}

