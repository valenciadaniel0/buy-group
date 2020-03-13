package com.buy.group.domain.model;

import java.util.List;

public class User {
    private Long id;
    private String username;
    private String password;
    private String deviceToken;
    private String name;
    private boolean active;  
    private City city;
    private List<Role> roles;      

    public User(Long id, String username, String password, String deviceToken, String name, boolean active, City city) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.deviceToken = deviceToken;
        this.name = name;
        this.active = active;
        this.city = city;        
    }        

    public Long getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
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

    public boolean isActive() {
        return this.active;
    }

    public boolean getActive() {
        return this.active;
    }   

    public City getCity() {
        return this.city;
    }       
}