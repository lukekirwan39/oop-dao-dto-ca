package org.example;

import org.example.DAOs.*;
import org.example.DTOs.ExpenseDTO;
import org.example.DTOs.IncomeDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

// GitHub Link
// https://github.com/lukekirwan39/oop-dao-dto-ca.git

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DBC.getConnection()) {
            ExpenseDaoInterface eDaoInterface = new ExpenseDAO(conn);
            IncomeDaoInterface iDaoInterface = new IncomeDAO(conn);
            FinanceDaoInterface fDaoInterface = new FinanceDAO(conn);

//            ExpenseDAO expenseDAO = new ExpenseDAO(conn);
//            IncomeDAO incomeDAO = new IncomeDAO(conn);
//            FinanceDAO dao = new FinanceDAO(conn);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n1. List all expenses");
                System.out.println("2. Add an expense");
                System.out.println("3. Delete an expense");
                System.out.println("4. List all income");
                System.out.println("5. Add income");
                System.out.println("6. Delete income");
                System.out.println("7. Display a month for Income and Expenses");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        List<ExpenseDTO> expenses = eDaoInterface.getAll();
                        double totalExpense = 0;
                        for (ExpenseDTO e : expenses) {
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
                        eDaoInterface.add(new ExpenseDTO(0, title, category, amount, java.sql.Date.valueOf(date)));
                        break;

                    case 3:
                        System.out.print("Enter expense ID to delete: ");
                        int expId = scanner.nextInt();
                        eDaoInterface.delete(expId);
                        break;

                    case 4:
                        List<IncomeDTO> income = iDaoInterface.getAll();
                        double totalIncome = 0;
                        for (IncomeDTO e : income) {
                            System.out.println(e);
                            totalIncome += e.getAmount();
                        }
                        System.out.println("Total expenses: €" + totalIncome);
                        break;

                    case 5:
                        System.out.print("Enter title: ");
                        String incTitle = scanner.next();
                        System.out.print("Enter amount: ");
                        double incAmount = scanner.nextDouble();
                        System.out.print("Enter date (yyyy-mm-dd): ");
                        String incDate = scanner.next();
                        iDaoInterface.add(new IncomeDTO(0, incTitle, incAmount, java.sql.Date.valueOf(incDate)));
                        break;

                    case 6:
                        System.out.print("Enter income ID to delete: ");
                        int incId = scanner.nextInt();
                        iDaoInterface.delete(incId);
                        break;

                    case 7:
                        System.out.print("Enter month (1-12): ");
                        int month = scanner.nextInt();
                        System.out.print("Enter year: ");
                        int year = scanner.nextInt();

                        System.out.println("\n=== Transactions for " + month + "/" + year + " ===");
                        List<Object> transactions = fDaoInterface.getTransactionsForMonth(month, year);
                        for (Object transaction : transactions) {
                            System.out.println(transaction);
                        }

                        fDaoInterface.getTotalSummary(month, year);
                        break;

                    case 8:
                        System.out.println("Exiting...");
                        return;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}