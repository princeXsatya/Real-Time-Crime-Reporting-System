package com.CrimeReport.controllers;

import com.CrimeReport.dao.UserDAO;
import com.CrimeReport.models.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegistrationForm {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JPanel mainPanel;

    public UserRegistrationForm() {
        // Initialize the components manually
        mainPanel = new JPanel(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10)); // For example

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        registerButton = new JButton("Register");

        // Add components to form panel
        formPanel.add(usernameLabel);
        formPanel.add(usernameField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);
        formPanel.add(new JLabel(""));  // filler
        formPanel.add(registerButton);

        // Add formPanel to mainPanel
        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Add Action Listener to the button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    User user = new User();
                    user.setUsername(usernameField.getText());
                    user.setPassword(new String(passwordField.getPassword()));
                    // Assuming UserDAO has a saveUser method
                    UserDAO userDAO = new UserDAO();
                    userDAO.saveUser(user);
                    JOptionPane.showMessageDialog(null, "User registered successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("User Registration");
        frame.setContentPane(new UserRegistrationForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
