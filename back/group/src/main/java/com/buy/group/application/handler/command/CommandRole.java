package com.buy.group.application.handler.command;

import java.util.List;

import com.buy.group.domain.model.User;

public class CommandRole {
    private Long id;
    private String name;
    private List<User> users;

    public CommandRole() {
    }

    public CommandRole(Long id, String name, List<User> users) {
        this.id = id;
        this.name = name;
        this.users = users;
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