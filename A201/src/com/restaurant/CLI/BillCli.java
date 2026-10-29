package com.restaurant.CLI;

import com.restaurant.models.Bill;
import com.restaurant.models.Order;
import com.restaurant.service.BillService;
import com.restaurant.service.OrderService;
import java.util.Scanner;

public class BillCli {

    private final OrderService orderService;
    private final BillService billService;

    public BillCli() {
        orderService = new OrderService();
        billService = new BillService();
    }

    public BillCli(OrderService orderService, BillService billService) {
        this.orderService = orderService;
        this.billService = billService;
    }

    public void call() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nBILL MANAGEMENT");
            System.out.println("Press 1 to GENERATE BILL");
            System.out.println("Press 2 to VIEW ALL BILLS");
            System.out.println("Press 3 to SEARCH BILL");
            System.out.println("Press 4 to EXIT");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter order ID: ");
                    int orderId = sc.nextInt();

                    Order order = orderService.search(orderId);

                    if (order == null) {
                        System.out.println("Order not found");
                        break;
                    }

                    Bill bill = billService.generateBill(order);
                    System.out.println("Bill generated successfully");
                    System.out.println(bill);
                    break;

                case 2:
                    for (Bill item : billService.getall()) {
                        System.out.println(item);
                    }
                    break;

                case 3:
                    System.out.print("Enter bill ID: ");
                    int billId = sc.nextInt();

                    Bill found = billService.search(billId);

                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Bill not found");
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
