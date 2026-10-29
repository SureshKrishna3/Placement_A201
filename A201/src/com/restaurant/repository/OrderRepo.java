package com.restaurant.repository;

import java.util.ArrayList;
import java.util.List;
import com.restaurant.models.Order;

public class OrderRepo {
    private final List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        orders.add(order);
    }

    public List<Order> show() {
        return orders;
    }

    public Order search(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }
}
