package com.qap4.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.qap4.entities.Drug;

public class FileService {

    private static final String FILE_NAME = "drugs.txt";

    // Save a Drug object to a text file
    public void saveDrugToFile(Drug drug) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(drug.getDrugId() + "," +
                         drug.getDrugName() + "," +
                         drug.getDrugCost() + "," +
                         drug.getDosage());
            writer.newLine();
            System.out.println("Drug saved to file successfully!");
        } catch (IOException e) {
            System.out.println("Error saving drug to file: " + e.getMessage());
        }
    }

    // Read all drugs from the text file
    public List<Drug> readDrugsFromFile() {
        List<Drug> drugs = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    double cost = Double.parseDouble(parts[2]);
                    String dosage = parts[3];

                    drugs.add(new Drug(id, name, cost, dosage));
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found. No drugs saved yet.");
        } catch (IOException e) {
            System.out.println("Error reading drugs from file: " + e.getMessage());
        }

        return drugs;
    }
}
