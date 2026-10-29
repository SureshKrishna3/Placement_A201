package com.restaurant.models;

public class Menu {
    private int id;
    private String foodName;
    private double price;

    public Menu(int id, String foodName,double price){
        this.id = id;
        this.foodName = foodName;
        this.price = price;
    }

    public int getId(){
        return id;
    }

    public String getFoodName(){
        return foodName;
    }
    
    public double getPrice(){
        return price;
    }

    public void setFoodName(String foodName){
        this.foodName = foodName;
    }

    public void setPrice(double price){
        this.price = price;
    }
}
