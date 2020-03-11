package com.buy.group.domain.model;
public class City{
    private String id;
    private String name;
    private Department department;    

    public City(String id, String name, Department department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }    
}