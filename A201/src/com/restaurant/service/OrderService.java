package com.restaurant.service;

import java.util.List;
import com.restaurant.models.Menu;
import com.restaurant.models.Order;
import com.restaurant.repository.OrderRepo;

public class OrderService {
    private final OrderRepo repository;
    private final menuService menuService;
    private int nextOrderId = 1;

    public OrderService() {
        repository = new OrderRepo();
        menuService = new menuService();
    }

    public Order createOrder(int tableId, int menuId, int quantity) {
        Menu item = menuService.search(menuId);

        if (item == null || quantity <= 0) {
            return null;
        }

        double total = item.getPrice() * quantity;

        Order order = new Order(
                nextOrderId++,
                tableId,
                menuId,
                quantity,
                total
        );

        repository.add(order);
        return order;
    }

    public List<Order> getall() {
        return repository.show();
    }

    public Order search(int orderId) {
        return repository.search(orderId);
    }
}
