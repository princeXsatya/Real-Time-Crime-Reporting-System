package com.CrimeReport.controllers;

import com.CrimeReport.dao.CrimeDAO;
import com.CrimeReport.models.Crime;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrimeReportingForm {
    private JTextField descriptionField;
    private JTextField locationField;
    private JTextField imagePathField;
    private JButton reportButton;
    private JPanel mainPanel;

    public CrimeReportingForm() {
        reportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Crime crime = new Crime();
                    crime.setDescription(descriptionField.getText());
                    crime.setLocation(locationField.getText());
                    crime.setImagePath(imagePathField.getText());
                    CrimeDAO crimeDAO = new CrimeDAO();
                    crimeDAO.saveCrime(crime);
                    JOptionPane.showMessageDialog(null, "Crime reported successfully!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Crime Reporting");
        frame.setContentPane(new CrimeReportingForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
