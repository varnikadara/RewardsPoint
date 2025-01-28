package com.example.rewardpoints.model;

public class Transaction {
    private final String customerName;
    private final double amount;
    private final String date;

    public Transaction(String customerName, double amount, String date) {
        this.customerName = customerName;
        this.amount = amount;
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
}
