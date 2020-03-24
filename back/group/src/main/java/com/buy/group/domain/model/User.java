package com.buy.group.domain.model;

import java.util.List;

public class User {
    private static final String USERNAME_IS_REQUIRED = "The username field is required";
    private static final String EMAIL_IS_REQUIRED = "The email field is required";
    private static final String PASSWORD_IS_REQUIRED = "The password field is required";
    private static final String NAME_IS_REQUIRED = "The name field is required";

    private Long id;
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

    public User(String username,String email, String password, String deviceToken, String name, Integer active, City city,
            List<Role> roles, List<Buyer> buyers, List<Company> companies) {
        DataValidator.validateNull(username, USERNAME_IS_REQUIRED);
        DataValidator.validateNull(email, EMAIL_IS_REQUIRED);
        DataValidator.validateNull(password, PASSWORD_IS_REQUIRED);
        DataValidator.validateNull(name, NAME_IS_REQUIRED);
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

    public Long getId() {
        return this.id;
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