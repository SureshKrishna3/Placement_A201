package com.restaurant.service;

import java.util.List;
import com.restaurant.models.Bill;
import com.restaurant.models.Order;
import com.restaurant.repository.BillRepo;

public class BillService {
    private final BillRepo repository;
    private int nextBillId = 1;

    public BillService() {
        repository = new BillRepo();
    }

    public Bill generateBill(Order order) {
        if (order == null) {
            return null;
        }

        Bill bill = new Bill(
                nextBillId++,
                order.getOrderId(),
                order.getTotal()
        );

        repository.add(bill);
        return bill;
    }

    public List<Bill> getall() {
        return repository.show();
    }

    public Bill search(int billId) {
        return repository.search(billId);
    }

    public Bill searchByOrderId(int orderId) {
        return repository.searchByOrderId(orderId);
    }
}
