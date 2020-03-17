package com.buy.group.domain.model;

import java.util.List;

public class Department {
    private Long id;
    private String code;
    private String name;
    private List<City> cities;

    public Department(String code, String name, List<City> cities) {        
        this.code = code;
        this.name = name;
        this.cities = cities;
    }

    public Long getId(){
        return this.id;
    }

    public String getCode(){
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public List<City> getCities(){
        return this.cities;
    }
}