package com.restaurant.repository;

import java.util.ArrayList;
import java.util.List;
import com.restaurant.models.Bill;

public class BillRepo {
    private final List<Bill> bills = new ArrayList<>();

    public void add(Bill bill) {
        bills.add(bill);
    }

    public List<Bill> show() {
        return bills;
    }

    public Bill search(int billId) {
        for (Bill bill : bills) {
            if (bill.getBillId() == billId) {
                return bill;
            }
        }
        return null;
    }

    public Bill searchByOrderId(int orderId) {
        for (Bill bill : bills) {
            if (bill.getOrderId() == orderId) {
                return bill;
            }
        }
        return null;
    }
}
