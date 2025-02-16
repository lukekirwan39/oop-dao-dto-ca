package org.example.DAOs;

import org.example.DBC;
import org.example.DTOs.IncomeDTO;
import org.example.Exceptions.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncomeDAO implements IncomeDaoInterface {
    private Connection conn;

    public IncomeDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void add(IncomeDTO income) throws SQLException {
        conn = DBC.getConnection();
        String sql = "INSERT INTO income (title, amount, dateEarned) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, income.getTitle());
            stmt.setDouble(2, income.getAmount());
            stmt.setDate(3, new java.sql.Date(income.getDateEarned().getTime()));
            stmt.executeUpdate();

        }
    }

    @Override
    public List<IncomeDTO> getAll() throws SQLException {
        List<IncomeDTO> incomeList = new ArrayList<>();
        String sql = "SELECT * FROM income";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                incomeList.add(new IncomeDTO(
                        rs.getInt("incomeID"),
                        rs.getString("title"),
                        rs.getDouble("amount"),
                        rs.getDate("dateEarned")
                ));
            }
        } catch (SQLException e) {
            throw new DaoException("getAll() " + e.getMessage());
        }
        return incomeList;
    }

    @Override
    public void delete(int incomeId) throws SQLException {
        String sql = "DELETE FROM income WHERE incomeID = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, incomeId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("delete() " + e.getMessage());
        }
    }
}
