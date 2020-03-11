package com.buy.group.domain.model;

public class User{
    private Long id;
    private String username;
    private String password;
    private String deviceToken;
    private String name;
    private boolean active;  
    private City city;  
    private Role role;

    public User(Long id, String username, String password, String deviceToken, String name, boolean active, City city,Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.deviceToken = deviceToken;
        this.name = name;
        this.active = active;
        this.city = city;
        this.role = role;
    }    
}