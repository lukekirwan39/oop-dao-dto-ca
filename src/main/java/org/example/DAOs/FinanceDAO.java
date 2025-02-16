package org.example.DAOs;

import org.example.DBC;
import org.example.DTOs.ExpenseDTO;
import org.example.DTOs.IncomeDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FinanceDAO implements FinanceDaoInterface {
    private Connection conn;

    public FinanceDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Object> getTransactionsForMonth(int month, int year) {
        List<Object> transactions = new ArrayList<>();
        // https://stackoverflow.com/questions/70101884/sql-query-to-determine-income-statement
        // Some sql code was taken from this link
        String sql = "WITH income_summary AS ( " +
                "SELECT 'Income' AS Type, incomeID AS ID, title, amount, dateEarned AS Date " +
                "FROM income WHERE MONTH(dateEarned) = ? AND YEAR(dateEarned) = ? " +
                "), expense_summary AS ( " +
                "SELECT 'Expense' AS Type, expenseID AS ID, title, amount, dateIncurred AS Date " +
                "FROM expenses WHERE MONTH(dateIncurred) = ? AND YEAR(dateIncurred) = ? " +
                ") " +
                "SELECT * FROM income_summary " +
                "UNION ALL " +
                "SELECT * FROM expense_summary " +
                "ORDER BY Date";

        try (Connection conn = DBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, month);
            stmt.setInt(2, year);
            stmt.setInt(3, month);
            stmt.setInt(4, year);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String type = rs.getString("Type");
                int id = rs.getInt("ID");
                String title = rs.getString("title");
                double amount = rs.getDouble("amount");
                Date date = rs.getDate("Date");

                if (type.equals("Income")) {
                    transactions.add(new IncomeDTO(id, title, amount, date));
                } else {
                    transactions.add(new ExpenseDTO(id, title, "General", amount, date));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return transactions;
    }

    @Override
    public void getTotalSummary(int month, int year) {
        // https://stackoverflow.com/questions/63104790/calculating-income-expenses-using-3-tables-in-sql
        // Used for the sql code
        String sql = "SELECT " +
                "(SELECT COALESCE(SUM(amount), 0) FROM income WHERE MONTH(dateEarned) = ? AND YEAR(dateEarned) = ?) AS Total_Income, " +
                "(SELECT COALESCE(SUM(amount), 0) FROM expenses WHERE MONTH(dateIncurred) = ? AND YEAR(dateIncurred) = ?) AS Total_Expenses";

        try (Connection conn = DBC.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, month);
            stmt.setInt(2, year);
            stmt.setInt(3, month);
            stmt.setInt(4, year);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                double totalIncome = rs.getDouble("Total_Income");
                double totalExpenses = rs.getDouble("Total_Expenses");
                double remainingBalance = totalIncome - totalExpenses;

                System.out.println("\n=== Monthly Financial Summary ===");
                System.out.println("Total Income: €" + totalIncome);
                System.out.println("Total Expenses: €" + totalExpenses);
                System.out.println("Remaining Balance: €" + remainingBalance);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
