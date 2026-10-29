package com.restaurant.CLI;

import com.restaurant.service.menuService;
import java.util.List;
import java.util.Scanner;
import com.restaurant.models.Menu;

public class menuCli {
    public void call(){
        Scanner sc = new Scanner(System.in);
        menuService service = new menuService();

        while(true){
            System.out.println("\nMENU ITEMS");
            System.out.println("Press 1 to VIEW MENU");
            System.out.println("Press 2 to ADD ITEM");
            System.out.println("Press 3 to SEARCH ITEM");
            System.out.println("Press 4 to UPDATE ITEM");
            System.out.println("Press 5 to DELETE ITEM");
            System.out.println("Press 6 to EXIT");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    List<Menu> items = service.getall();

                    System.out.println("\nID\tFOODITEMS\tPRICE");

                    for(Menu item : items){
                        System.out.println(item.getId() + "\t" + item.getFoodName() + "\t" + item.getPrice());
                    }
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter food name: ");
                    String foodName = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    service.add(new Menu(id, foodName, price));
                    System.out.println("Menu item added successfully");
                    break;

                case 3:
                    System.out.print("Enter menu ID: ");
                    int searchId = sc.nextInt();
                    Menu found = service.search(searchId);

                    if(found != null){
                        System.out.println("ID: " + found.getId());
                        System.out.println("Food: " + found.getFoodName());
                        System.out.println("Price: " + found.getPrice());
                    }else{
                        System.out.println("Menu item not found");
                    }
                    break;

                case 4:
                    System.out.print("Enter menu ID: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new food name: ");
                    String newFoodName = sc.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();

                    if(service.update(updateId, newFoodName, newPrice)){
                        System.out.println("Menu item updated successfully");
                    }else{
                        System.out.println("Menu item not found");
                    }
                    break;

                case 5:
                    System.out.print("Enter menu ID: ");
                    int deleteId = sc.nextInt();

                    if(service.delete(deleteId)){
                        System.out.println("Menu item deleted successfully");
                    }else{
                        System.out.println("Menu item not found");
                    }
                    break;

                case 6:
                    System.out.println("Thank you");
                    return;
            
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        }
    } 
}
