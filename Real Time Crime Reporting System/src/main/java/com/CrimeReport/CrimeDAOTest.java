package com.CrimeReport;

import com.CrimeReport.dao.CrimeDAO;
import com.CrimeReport.models.Crime;

import java.sql.SQLException;
import java.util.List;

public class CrimeDAOTest {
    public static void main(String[] args) {
        try {
            // Create a new Crime object and set its properties
            Crime newCrime = new Crime();
            newCrime.setDescription("Test Crime Description");
            newCrime.setLocation("Test Location");
            newCrime.setImagePath("testImage.jpg");

            // Instantiate your DAO and save the crime
            CrimeDAO crimeDAO = new CrimeDAO();
            crimeDAO.saveCrime(newCrime);
            System.out.println("Crime saved with ID: " + newCrime.getId());

            // Retrieve all crimes from the database
            List<Crime> crimes = crimeDAO.findAllCrimes();
            System.out.println("Total crimes in the database: " + crimes.size());
            for(Crime c : crimes) {
                System.out.println("ID: " + c.getId() + " | Description: " + c.getDescription() +
                        " | Location: " + c.getLocation() + " | Image Path: " + c.getImagePath());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
