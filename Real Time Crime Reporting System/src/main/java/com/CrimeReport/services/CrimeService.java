package com.CrimeReport.services;

import com.CrimeReport.dao.CrimeDAO;
import com.CrimeReport.models.Crime;
import java.sql.SQLException;
import java.util.List;

public class CrimeService {
    private CrimeDAO crimeDAO;

    public CrimeService() throws SQLException {
        this.crimeDAO = new CrimeDAO();
    }

    public List<Crime> findAllCrimes() throws SQLException {
        return crimeDAO.findAllCrimes();
    }
}
