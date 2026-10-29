package com.restaurant.service;

import java.util.List;

import com.restaurant.models.Menu;
import com.restaurant.repository.menuRepo;

public class menuService {

    private final menuRepo repository;

    public menuService() {
        repository = new menuRepo();
    }

    public List<Menu> getall() {
        return repository.show();
    }

    public void add(Menu item){
        repository.add(item);
    }

    public Menu search(int id){
        return repository.search(id);
    }

    public boolean update(int id, String foodName, double price){
        Menu item = repository.search(id);
        if(item != null){
            item.setFoodName(foodName);
            item.setPrice(price);
            return true;
        }
        return false;
    }

    public boolean delete(int id){
        return repository.delete(id);
    }
}
