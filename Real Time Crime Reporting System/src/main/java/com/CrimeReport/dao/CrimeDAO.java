package com.CrimeReport.dao;

import com.CrimeReport.models.Crime;
import com.CrimeReport.config.DatabaseConfig;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrimeDAO {
    private Connection connection;

    public CrimeDAO() throws SQLException {
        // Initialize the connection (modify as per your configuration)
        connection = DatabaseConfig.getConnection();
    }

    // Method to retrieve all crimes from the database
    public List<Crime> findAllCrimes() throws SQLException {
        List<Crime> crimes = new ArrayList<>();
        String query = "SELECT * FROM crimes";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Crime crime = new Crime();
            crime.setId(resultSet.getLong("id"));
            crime.setDescription(resultSet.getString("description"));
            crime.setLocation(resultSet.getString("location"));
            crime.setImagePath(resultSet.getString("image_path"));
            crimes.add(crime);
        }

        return crimes;
    }

    // New method to save a crime into the database
    public void saveCrime(Crime crime) throws SQLException {
        String sql = "INSERT INTO crimes (description, location, image_path) VALUES (?, ?, ?)";
        // Using try-with-resources to ensure the PreparedStatement is closed automatically
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, crime.getDescription());
            statement.setString(2, crime.getLocation());
            statement.setString(3, crime.getImagePath());
            // Execute the insert
            statement.executeUpdate();

            // Optionally, retrieve the auto-generated key and set it on the Crime object
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                crime.setId(generatedKeys.getLong(1));
            }
        }
    }
}
