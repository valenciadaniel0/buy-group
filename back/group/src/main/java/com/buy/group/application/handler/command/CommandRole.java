package com.buy.group.application.handler.command;

import java.util.List;

import com.buy.group.domain.model.User;

public class CommandRole{
    private String name;
    private List<User> users;

    public CommandRole(String name, List<User> users){
        this.name = name;
        this.users = users;
    }

    public String getName(){
        return this.name;
    }

    public List<User> getUsers(){
        return this.users;
    }
}