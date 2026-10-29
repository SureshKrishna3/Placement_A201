package com.restaurant.service;

import com.restaurant.repository.TableRepo;
import java.util.List;
import com.restaurant.models.Table;

public class TableService {
    private final TableRepo repository;

    public TableService(){
        repository = new TableRepo();
    }

    public List<Table> getall(){
        return repository.show();
    }

    public void add(Table table){
        repository.add(table);
    }

    public boolean booking(int id){
        Table table = repository.search(id);
        if(table != null && table.getStatus() == Table.Availability.free){
            table.booking();
            return true;
        }
        return false;
    }

    public boolean freeNow(int id){
        Table table = repository.search(id);
        if(table != null && table.getStatus() == Table.Availability.occupy){
            table.freeNow();
            return true;
        }
        return false;
    }

    public List<Table> available(){
        List<Table> availableTables = new java.util.ArrayList<>();
        for(Table table : repository.show()){
            if(table.getStatus() == Table.Availability.free){
                availableTables.add(table);
            }
        }
        return availableTables;
    }
}
