package org.example;

import org.example.DAOs.ExpenseDAO;
import org.example.DAOs.IncomeDAO;
import org.example.DTOs.ExpenseDTO;

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

                        break;

                    case 3:

                        break;

                    case 4:

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