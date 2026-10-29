package com.restaurant.models;

public class Payment {

    private final int id;
    private final int orderId;
    private final double bill;
    private final double amount;
    private final String method;
    private final String status;

    public Payment(int id, int orderId, double bill,
            double amount, String method, String status) {
        this.id = id;
        this.orderId = orderId;
        this.bill = bill;
        this.amount = amount;
        this.method = method;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getBill() {
        return bill;
    }

    public double getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Payment ID: " + id
                + ", Order ID: " + orderId
                + ", Bill: Rs. " + String.format("%.2f", bill)
                + ", Amount: Rs. " + String.format("%.2f", amount)
                + ", Method: " + method
                + ", Status: " + status;
    }
}
