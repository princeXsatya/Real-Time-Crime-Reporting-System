package com.CrimeReport.dao;

import com.CrimeReport.config.DatabaseConfig;
import com.CrimeReport.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection connection;

    public UserDAO() throws SQLException {
        this.connection = DatabaseConfig.getConnection();
    }

    public void saveUser(User user) throws SQLException {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        statement.executeUpdate();
    }

    public User findByUsername(String username) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            return user;
        }
        return null;
    }
}

