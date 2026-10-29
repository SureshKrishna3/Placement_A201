package com.restaurant.CLI;

import com.restaurant.models.Bill;
import com.restaurant.models.Payment;
import com.restaurant.payment.*;
import com.restaurant.service.BillService;
import com.restaurant.service.OrderService;
import com.restaurant.service.PaymentService;

import java.util.Scanner;

public class PaymentCli {

    private final PaymentService service;
    private final OrderService orderService;
    private final BillService billService;
    private final Scanner scanner = new Scanner(System.in);

    public PaymentCli() {
        service = new PaymentService();
        orderService = new OrderService();
        billService = new BillService();
    }

    public PaymentCli(PaymentService service, OrderService orderService, BillService billService) {
        this.service = service;
        this.orderService = orderService;
        this.billService = billService;
    }

    public void call() {
        int choice = -1;

        do {
            System.out.println("\n=== RESTAURANT PAYMENT SYSTEM ===");
            System.out.println("1. Make Payment");
            System.out.println("2. View All Payments");
            System.out.println("3. Find Payment by ID");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    makePayment();
                    break;

                case 2:
                    viewAllPayments();
                    break;

                case 3:
                    findPayment();
                    break;

                case 0:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private void makePayment() {
        System.out.print("Enter order ID: ");
        int orderId = scanner.nextInt();

        com.restaurant.models.Order order = orderService.search(orderId);

        if (order == null) {
            System.out.println("Order not found.");
            return;
        }

        Bill bill = billService.searchByOrderId(orderId);

        if (bill == null) {
            bill = billService.generateBill(order);
        }

        System.out.println("Bill Amount: Rs. " + String.format("%.2f", bill.getAmount()));

        System.out.println("\nSelect Payment Method");
        System.out.println("1. Cash");
        System.out.println("2. Card");
        System.out.println("3. UPI");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();

        PaymentMethod method;

        switch (choice) {
            case 1:
                method = new CashPayment();
                break;
            case 2:
                method = new CardPayment();
                break;
            case 3:
                method = new UPIPayment();
                break;
            default:
                System.out.println("Invalid payment method.");
                return;
        }

        Payment payment = service.processPayment(
                orderId,
                bill.getAmount(),
                method
        );

        System.out.println("Payment record saved.");
        System.out.println(payment);
    }

    private void viewAllPayments() {
        if (service.getAllPayments().isEmpty()) {
            System.out.println("No payment records found.");
            return;
        }

        for (Payment payment : service.getAllPayments()) {
            System.out.println(payment);
        }
    }

    private void findPayment() {
        System.out.print("Enter payment ID: ");
        int id = scanner.nextInt();

        Payment payment = service.getPaymentById(id);

        if (payment != null) {
            System.out.println(payment);
        } else {
            System.out.println("Payment not found.");
        }
    }
}
