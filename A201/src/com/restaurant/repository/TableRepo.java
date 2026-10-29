package com.restaurant.repository;

import com.restaurant.models.Table;
import java.util.List;
import java.util.ArrayList;

public class TableRepo {
    private final List<Table> tableInfo = new ArrayList<>();

    public TableRepo(){
        tableInfo.add(new Table(401,4));
        tableInfo.add(new Table(201,2));
        tableInfo.add(new Table(402,4));
    }

    public List<Table> show(){
        return tableInfo;
    }

    public void add(Table table){
        tableInfo.add(table);
    }

    public Table search(int id){
        for(Table table : tableInfo){
            if(table.getId() == id){
                return table;
            }
        }
        return null;
    }
}
