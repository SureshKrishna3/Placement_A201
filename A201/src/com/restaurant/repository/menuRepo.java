package com.restaurant.repository;

import java.util.List;
import java.util.ArrayList;
import com.restaurant.models.Menu;

public class menuRepo {
    private final List<Menu> menuTable = new ArrayList<>();
      
    public menuRepo(){
       menuTable.add(new Menu(1,"Dosa",50.5));
       menuTable.add(new Menu(2,"Idly",10));
       menuTable.add(new Menu(3,"Chappathi",25));

    }

    public List<Menu> show(){
        return menuTable;
    }

    public void add(Menu item){
        menuTable.add(item);
    }

    public Menu search(int id){
        for(Menu item : menuTable){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public boolean delete(int id){
        for(int i = 0; i < menuTable.size(); i++){
            if(menuTable.get(i).getId() == id){
                menuTable.remove(i);
                return true;
            }
        }
        return false;
    }
    
}
