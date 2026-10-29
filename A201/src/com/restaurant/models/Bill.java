package com.restaurant.models;

public class Bill {
    private final int billId;
    private final int orderId;
    private final double amount;

    public Bill(int billId, int orderId, double amount) {
        this.billId = billId;
        this.orderId = orderId;
        this.amount = amount;
    }

    public int getBillId() {
        return billId;
    }

    public int getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Bill ID: " + billId
                + ", Order ID: " + orderId
                + ", Amount: Rs. " + String.format("%.2f", amount);
    }
}
