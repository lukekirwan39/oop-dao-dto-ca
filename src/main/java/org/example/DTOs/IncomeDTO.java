package org.example.DTOs;

import java.util.Date;

public class IncomeDTO {
    private int incomeID;
    private String title;
    private double amount;
    private Date dateEarned;

    public IncomeDTO(int incomeID, double amount, String title, Date dateEarned) {
        this.incomeID = incomeID;
        this.amount = amount;
        this.title = title;
        this.dateEarned = dateEarned;
    }

    public int getIncomeID() {
        return incomeID;
    }

    public void setIncomeID(int incomeID) {
        this.incomeID = incomeID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDateEarned() {
        return dateEarned;
    }

    public void setDateEarned(Date dateEarned) {
        this.dateEarned = dateEarned;
    }

    @Override
    public String toString() {
        return "IncomeDTO{" +
                "incomeID=" + incomeID +
                ", title='" + title + '\'' +
                ", amount=" + amount +
                ", dateEarned=" + dateEarned +
                '}';
    }
}
