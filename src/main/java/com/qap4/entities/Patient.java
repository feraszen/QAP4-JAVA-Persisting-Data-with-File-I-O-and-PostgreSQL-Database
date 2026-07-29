package com.qap4.entities;

public class Patient {
    private int patientId;
    private String patientFirstName;
    private String patientLastName;
    private String patientDOB;

    public Patient(int patientId, String patientFirstName, String patientLastName, String patientDOB) {
        this.patientId = patientId;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientDOB = patientDOB;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public String getPatientDOB() {
        return patientDOB;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
               ", Name: " + patientFirstName + " " + patientLastName +
               ", DOB: " + patientDOB;
    }
}
