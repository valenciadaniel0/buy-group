package com.buy.group.domain.model;

import java.util.List;

public class Department {
    private Long id;
    private String code;
    private String name;
    private List<City> cities;

    public Department(Long id,String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public String getCode(){
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public List<City> cities(){
        return this.cities;
    }
}