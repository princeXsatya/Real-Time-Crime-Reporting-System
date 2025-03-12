package com.CrimeReport.controllers;

import com.CrimeReport.models.Crime;
import com.CrimeReport.services.CrimeService;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class AdminDashboard {
    private JPanel mainPanel;
    private JTable crimeTable;
    private JButton refreshButton;

    public AdminDashboard() {
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    CrimeService crimeService = new CrimeService();
                    List<Crime> crimes = crimeService.findAllCrimes();
                    // Update crimeTable with crimes data. For example:
                    // crimeTable.setModel(new CrimeTableModel(crimes));
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Admin Dashboard");
        frame.setContentPane(new AdminDashboard().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
