package org.example;

import org.example.DAOs.ExpenseDAO;
import org.example.DAOs.IncomeDAO;
import org.example.DTOs.ExpenseDTO;
import org.example.DTOs.IncomeDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try(Connection conn = DBC.getConnection()){
            ExpenseDAO expenseDAO = new ExpenseDAO(conn);
            IncomeDAO incomeDAO = new IncomeDAO(conn);
            Scanner scanner = new Scanner(System.in);

            while (true){
                System.out.println("\n1. List all expenses");
                System.out.println("2. Add an expense");
                System.out.println("3. Delete an expense");
                System.out.println("4. List all income");
                System.out.println("5. Add income");
                System.out.println("6. Delete income");
                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice){
                    case 1:
                        List<ExpenseDTO> expenses = expenseDAO.getAllExpenses();
                        double totalExpense = 0;
                        for (ExpenseDTO e: expenses){
                            System.out.println(e);
                            totalExpense += e.getAmount();
                        }
                        System.out.println("Total expenses: €" + totalExpense);
                        break;

                    case 2:
                        System.out.print("Enter title: ");
                        String title = scanner.next();
                        System.out.print("Enter category: ");
                        String category = scanner.next();
                        System.out.print("Enter amount: ");
                        double amount = scanner.nextDouble();
                        System.out.print("Enter date (yyyy-mm-dd): ");
                        String date = scanner.next();
                        expenseDAO.addExpense(new ExpenseDTO(0, title, category, amount, java.sql.Date.valueOf(date)));
                        break;

                    case 3:
                        System.out.print("Enter expense ID to delete: ");
                        int expId = scanner.nextInt();
                        expenseDAO.deleteExpense(expId);
                        break;

                    case 4:
                        List<IncomeDTO> income = incomeDAO.getAllIncome();
                        double totalIncome = 0;
                        for (IncomeDTO e: income){
                            System.out.println(e);
                            totalIncome += e.getAmount();
                        }
                        System.out.println("Total expenses: €" + totalIncome);
                        break;

                    case 5:

                        break;

                    case 6:

                        break;

                    case 7:
                        System.out.println("Exiting...");
                        return;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}