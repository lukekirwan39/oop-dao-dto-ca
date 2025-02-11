package org.example.DTOs;

import java.util.Date;

public class ExpenseDTO {
    private int expenseID;
    private String title;
    private String category;
    private double amount;
    private Date dateIncurred;

    public ExpenseDTO(int expenseID, String title, String category, double amount, Date dateIncurred) {
        this.expenseID = expenseID;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.dateIncurred = dateIncurred;
    }

    public int getExpenseID() {
        return expenseID;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public Date getDateIncurred() {
        return dateIncurred;
    }

    public double getAmount() {
        return amount;
    }

    public void setExpenseID(int expenseID) {
        this.expenseID = expenseID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDateIncurred(Date dateIncurred) {
        this.dateIncurred = dateIncurred;
    }

    @Override
    public String toString() {
        return "ExpenseDTO{" +
                "expenseID=" + expenseID +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", dateIncurred=" + dateIncurred +
                '}';
    }
}
