package com.buy.group.domain.model;

import java.util.List;

public class User {
    private static final String USERNAME_IS_REQUIRED = "The username is required";
    private static final String PASSWORD_IS_REQUIRED = "The password is required";
    private static final String NAME_IS_REQUIRED = "The name is required";

    private Long id;
    private String username;
    private String password;
    private String deviceToken;
    private String name;
    private Integer active;  
    private City city;
    private List<Role> roles;
    private List<Buyer> buyers;
    private List<Company> companies;
    
    public User(String username, String password, String deviceToken, String name, Integer active, City city, List<Role> roles, List<Buyer> buyers, List<Company> companies) {
        this.validateAttributes(username, password, name);       
        this.username = username;
        this.password = password;
        this.deviceToken = deviceToken;
        this.name = name;
        this.active = active;
        this.city = city; 
        this.roles = roles;
        this.buyers = buyers; 
        this.companies = companies;      
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
    
    public Integer getActive() {
        return this.active;
    }   

    public City getCity() {
        return this.city;
    }     
    
    public List<Role> getRoles(){
        return this.roles;
    }

    public List<Buyer> getBuyers(){
        return this.buyers;
    }

    public List<Company> getCompanies(){
        return this.companies;
    }

    //Esto huele a picho
    private void validateAttributes(String username, String password, String name){
        DataValidator.validateNull(username, User.USERNAME_IS_REQUIRED);
        DataValidator.validateNull(password, User.PASSWORD_IS_REQUIRED);
        DataValidator.validateNull(name, User.NAME_IS_REQUIRED);
    }
}