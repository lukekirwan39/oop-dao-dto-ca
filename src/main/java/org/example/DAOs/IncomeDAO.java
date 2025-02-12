package org.example.DAOs;

import org.example.DTOs.IncomeDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncomeDAO {
    private final Connection conn;

    public IncomeDAO(Connection conn) {
        this.conn = conn;
    }

    public void addIncome(IncomeDTO income) throws SQLException {
        String sql = "INSERT INTO income (title, amount, dateEarned) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, income.getTitle());
            stmt.setDouble(2, income.getAmount());
            stmt.setDate(3, new java.sql.Date(income.getDateEarned().getTime()));
            stmt.executeUpdate();
        }
    }

    public List<IncomeDTO> getAllIncome() throws SQLException {
        List<IncomeDTO> incomeList = new ArrayList<>();
        String sql = "SELECT * FROM income";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                incomeList.add(new IncomeDTO(
                        rs.getInt("incomeID"),
                        rs.getDouble("amount"),
                        rs.getString("title"),
                        rs.getDate("dateEarned")
                ));
            }
        }
        return incomeList;
    }
}
