package com.restaurant.CLI;

import java.util.Scanner;
import com.restaurant.service.TableService;
import java.util.List;
import com.restaurant.models.Table;

public class TableCli{

    public void call(){
    Scanner sc = new Scanner(System.in);
    TableService service = new TableService();

    while(true){
        System.out.println("\nTABLE MANAGEMENT");
        System.out.println("Press 1 to VIEW TABLES");
        System.out.println("Press 2 to ADD TABLE");
        System.out.println("Press 3 to BOOK TABLE");
        System.out.println("Press 4 to FREE TABLE");
        System.out.println("Press 5 to VIEW AVAILABLE TABLES");
        System.out.println("Press 6 to EXIT");
        System.out.print("Enter your choice: ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                List<Table> items = service.getall();
                System.out.println("\nID\tCAPACITY\tSTATUS");
                for(Table item : items){
                    System.out.println(item.getId() + "\t" + item.getCapacity() + "\t\t" + item.getStatus());
                }
                break;

            case 2:
                System.out.print("Enter table ID: ");
                int id = sc.nextInt();
                System.out.print("Enter table capacity: ");
                int capacity = sc.nextInt();
                service.add(new Table(id, capacity));
                System.out.println("Table added successfully");
                break;

            case 3:
                System.out.print("Enter table ID: ");
                int bookId = sc.nextInt();
                if(service.booking(bookId)){
                    System.out.println("Table booked successfully");
                }else{
                    System.out.println("Table not found or already occupied");
                }
                break;

            case 4:
                System.out.print("Enter table ID: ");
                int freeId = sc.nextInt();
                if(service.freeNow(freeId)){
                    System.out.println("Table is free now");
                }else{
                    System.out.println("Table not found or already free");
                }
                break;

            case 5:
                List<Table> available = service.available();
                System.out.println("\nAVAILABLE TABLES");
                System.out.println("ID\tCAPACITY\tSTATUS");
                for(Table item : available){
                    System.out.println(item.getId() + "\t" + item.getCapacity() + "\t\t" + item.getStatus());
                }
                break;

            case 6:
                System.out.println("Thank you");
                return;

            default:
                System.out.println("Invalid");
                break;
        }
        }
    }
}
