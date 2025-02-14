package org.example.DAOs;

import org.example.DTOs.ExpenseDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO implements FinanceDaoInterface<ExpenseDTO>{
    private Connection conn;

    public ExpenseDAO(Connection conn){
        this.conn = conn;
    }

    @Override
    public void add(ExpenseDTO expense) throws SQLException {
        String sql = "INSERT INTO expenses (title, category, amount, dateIncurred) VALUES (?, ?, ?, ?)";
        try(PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, expense.getTitle());
            stmt.setString(2, expense.getCategory());
            stmt.setDouble(3, expense.getAmount());
            stmt.setDate(4, new java.sql.Date(expense.getDateIncurred().getTime()));
            stmt.executeUpdate();
        }
    }

    @Override
    public List<ExpenseDTO> getAll() throws SQLException{
        List<ExpenseDTO> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses";
        try (Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()){
                expenses.add(new ExpenseDTO(
                        rs.getInt("expenseId"),
                        rs.getString("title"),
                        rs.getString("category"),
                        rs.getDouble("amount"),
                        rs.getDate("dateIncurred")
                ));
            }
        }
        return expenses;
    }

    @Override
    public void delete(int expenseID) throws SQLException {
        String sql = "DELETE FROM expenses WHERE expenseID = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, expenseID);
            stmt.executeUpdate();
        }
    }
}
