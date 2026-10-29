package com.restaurant.CLI;

import com.restaurant.models.Order;
import com.restaurant.service.OrderService;
import java.util.List;
import java.util.Scanner;

public class OrderCli {

    private final OrderService service;

    public OrderCli() {
        service = new OrderService();
    }

    public OrderCli(OrderService service) {
        this.service = service;
    }

    public void call() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nORDER MANAGEMENT");
            System.out.println("Press 1 to CREATE ORDER");
            System.out.println("Press 2 to VIEW ORDERS");
            System.out.println("Press 3 to SEARCH ORDER");
            System.out.println("Press 4 to EXIT");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter table ID: ");
                    int tableId = sc.nextInt();

                    System.out.print("Enter menu ID: ");
                    int menuId = sc.nextInt();

                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();

                    Order order = service.createOrder(tableId, menuId, quantity);

                    if (order != null) {
                        System.out.println("Order created successfully");
                        System.out.println(order);
                    } else {
                        System.out.println("Invalid menu ID or quantity");
                    }
                    break;

                case 2:
                    List<Order> orders = service.getall();

                    if (orders.isEmpty()) {
                        System.out.println("No orders found");
                    } else {
                        for (Order item : orders) {
                            System.out.println(item);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter order ID: ");
                    int orderId = sc.nextInt();

                    Order found = service.search(orderId);

                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Order not found");
                    }
                    break;

                case 4:
                    System.out.println("Thank you");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
