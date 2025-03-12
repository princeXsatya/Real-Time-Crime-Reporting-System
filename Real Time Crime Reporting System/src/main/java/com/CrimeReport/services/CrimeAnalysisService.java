package com.CrimeReport.services;

import com.CrimeReport.dao.CrimeDAO;
import com.CrimeReport.models.Crime;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrimeAnalysisService {
    private CrimeDAO crimeDAO;

    public CrimeAnalysisService() throws SQLException {
        this.crimeDAO = new CrimeDAO();
    }

    public Map<String, Integer> generateCrimeTrends() throws SQLException {
        List<Crime> crimes = crimeDAO.findAllCrimes();
        Map<String, Integer> crimeTrends = new HashMap<>();

        for (Crime crime : crimes) {
            String location = crime.getLocation();
            crimeTrends.put(location, crimeTrends.getOrDefault(location, 0) + 1);
        }

        return crimeTrends;
    }
}
