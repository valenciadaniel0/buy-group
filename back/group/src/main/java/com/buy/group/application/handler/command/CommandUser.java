package com.buy.group.application.handler.command;

import java.util.List;

import com.buy.group.domain.model.City;
import com.buy.group.domain.model.Role;

public class CommandUser {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String deviceToken;
    private String name;
    private Integer active;
    private String recoverCode;
    private City city;
    private List<Role> roles;

    public CommandUser() {
    }

    public CommandUser(Long id, String username, String email, String password, String deviceToken, String name,
            Integer active, String recoverCode, City city, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.deviceToken = deviceToken;
        this.name = name;
        this.active = active;
        this.recoverCode = recoverCode;
        this.city = city;
        this.roles = roles;
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

    public Integer isActive() {
        return this.active;
    }

    public Integer getActive() {
        return this.active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getRecoverCode() {
        return recoverCode;
    }

    public void setRecoverCode(String recoverCode) {
        this.recoverCode = recoverCode;
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
}