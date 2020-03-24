package com.buy.group.application.handler.command;

import java.util.List;

import com.buy.group.domain.model.Buyer;
import com.buy.group.domain.model.City;
import com.buy.group.domain.model.Company;
import com.buy.group.domain.model.Role;

public class CommandUser{
    private String username;
    private String email;
    private String password;
    private String deviceToken;
    private String name;
    private Integer active;  
    private City city;
    private List<Role> roles;
    private List<Buyer> buyers;
    private List<Company> companies;

    public CommandUser(String username,String email, String password, String deviceToken, String name, Integer active, City city, List<Role> roles, List<Buyer> buyers, List<Company> companies) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.deviceToken = deviceToken;
        this.name = name;
        this.active = active;
        this.city = city;
        this.roles = roles;
        this.buyers = buyers;
        this.companies = companies;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public String getDeviceToken() {
        return this.deviceToken;
    }

    public String getName() {
        return this.name;
    }

    public Integer isActive() {
        return this.active;
    }

    public Integer getActive() {
        return this.active;
    }

    public City getCity() {
        return this.city;
    }

    public List<Role> getRoles() {
        return this.roles;
    } 
    
    public List<Buyer> getBuyers() {
        return this.buyers;
    } 

    public List<Company> getCompanies() {
        return this.companies;
    }     
}