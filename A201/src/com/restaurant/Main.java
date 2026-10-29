package com.restaurant;

import com.restaurant.CLI.BillCli;
import com.restaurant.CLI.OrderCli;
import com.restaurant.CLI.PaymentCli;
import com.restaurant.CLI.TableCli;
import com.restaurant.CLI.menuCli;
import com.restaurant.service.BillService;
import com.restaurant.service.OrderService;
import com.restaurant.service.PaymentService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        OrderService orderService = new OrderService();
        BillService billService = new BillService();
        PaymentService paymentService = new PaymentService();

        while (true) {
            System.out.println("\n=== A201 RESTAURANT  ===");
            System.out.println("1. Table Management");
            System.out.println("2. Menu Management");
            System.out.println("3. Order Management");
            System.out.println("4. Bill Management");
            System.out.println("5. Payment Management");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    new TableCli().call();
                    break;

                case 2:
                    new menuCli().call();
                    break;

                case 3:
                    new OrderCli(orderService).call();
                    break;

                case 4:
                    new BillCli(orderService, billService).call();
                    break;

                case 5:
                    new PaymentCli(
                            paymentService,
                            orderService,
                            billService
                    ).call();
                    break;

                case 6:
                    System.out.println("Thank you");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
