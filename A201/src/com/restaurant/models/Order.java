package com.restaurant.models;

public class Order {
    private final int orderId;
    private final int tableId;
    private final int menuId;
    private final int quantity;
    private final double total;

    public Order(int orderId, int tableId, int menuId, int quantity, double total) {
        this.orderId = orderId;
        this.tableId = tableId;
        this.menuId = menuId;
        this.quantity = quantity;
        this.total = total;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getTableId() {
        return tableId;
    }

    public int getMenuId() {
        return menuId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId
                + ", Table ID: " + tableId
                + ", Menu ID: " + menuId
                + ", Quantity: " + quantity
                + ", Total: Rs. " + String.format("%.2f", total);
    }
}
