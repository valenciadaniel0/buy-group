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

    public User() {
    }

    public User(Long id, String username, String email, String password, String deviceToken, String name,
            Integer active, City city, List<Role> roles, List<Buyer> buyers, List<Company> companies) {
        DataValidator.validateNull(username, USERNAME_IS_REQUIRED);
        DataValidator.validateNull(email, EMAIL_IS_REQUIRED);
        DataValidator.validateNull(password, PASSWORD_IS_REQUIRED);
        DataValidator.validateNull(name, NAME_IS_REQUIRED);
        this.id = id;
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceToken() {
        return this.deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getActive() {
        return this.active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public City getCity() {
        return this.city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Buyer> getBuyers() {
        return this.buyers;
    }

    public void setBuyers(List<Buyer> buyers) {
        this.buyers = buyers;
    }

    public List<Company> getCompanies() {
        return this.companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}