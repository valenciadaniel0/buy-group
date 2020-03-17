package com.buy.group.domain.model;
public class City{
    private Long id;
    private String name;
    private String code;
    private Department department;    

    public City(Long id, String name,String code, Department department) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.department = department;
    }       

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public Department getDepartment() {
        return this.department;
    }    
}