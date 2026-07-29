package com.qap4.menu;

import java.util.List;
import java.util.Scanner;

import com.qap4.entities.Drug;
import com.qap4.entities.Patient;
import com.qap4.services.DatabaseService;
import com.qap4.services.FileService;

public class MenuHandler {

    private final FileService fileService = new FileService();
    private final DatabaseService databaseService = new DatabaseService();
    private final Scanner scanner = new Scanner(System.in);

    public void startMenu() {
        int choice;

        do {
            System.out.println("\n===== QAP4 Java Persistence Menu =====");
            System.out.println("1. Save Drug to File");
            System.out.println("2. Read Drugs from File");
            System.out.println("3. Save Patient to Database");
            System.out.println("4. Read Patients from Database");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    saveDrug();
                    break;
                case 2:
                    readDrugs();
                    break;
                case 3:
                    savePatient();
                    break;
                case 4:
                    readPatients();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);
    }

    private void saveDrug() {
        System.out.print("Enter Drug ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Drug Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Drug Cost: ");
        double cost = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Dosage: ");
        String dosage = scanner.nextLine();

        Drug drug = new Drug(id, name, cost, dosage);
        fileService.saveDrugToFile(drug);
    }

    private void readDrugs() {
        List<Drug> drugs = fileService.readDrugsFromFile();

        if (drugs.isEmpty()) {
            System.out.println("No drugs found.");
        } else {
            System.out.println("\n===== Drugs List =====");
            for (Drug d : drugs) {
                System.out.println(d);
            }
        }
    }

    private void savePatient() {
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter DOB (YYYY-MM-DD): ");
        String dob = scanner.nextLine();

        Patient patient = new Patient(id, firstName, lastName, dob);
        databaseService.savePatientToDatabase(patient);
    }

    private void readPatients() {
        List<Patient> patients = databaseService.readPatientsFromDatabase();

        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            System.out.println("\n===== Patients List =====");
            for (Patient p : patients) {
                System.out.println(p);
            }
        }
    }
}
