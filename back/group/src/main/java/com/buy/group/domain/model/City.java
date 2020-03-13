package com.buy.group.domain.model;
public class City{
    private Long id;
    private String name;
    private Department department;    

    public City(Long id, String name, Department department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }       

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Department getDepartment() {
        return this.department;
    }    
}