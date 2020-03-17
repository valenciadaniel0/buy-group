package com.buy.group.domain.model;

import java.util.List;

public class Role {
    private Long id;
    private String name;
    private List<User> users;

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    } 

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<User> getUsers() {
        return this.users;
    }
}