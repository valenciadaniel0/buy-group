package com.buy.group.framework.controller;

import com.buy.group.application.handler.command.CommandUser;
import com.buy.group.application.handler.users.HandlerCreateUser;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class ControllerUser {
    private HandlerCreateUser handlerCreateUser;

    public ControllerUser(HandlerCreateUser handlerCreateUser){
        this.handlerCreateUser = handlerCreateUser;
    }

    @PostMapping(value = "/register")
    public void create(@RequestBody CommandUser commandUser){
        this.handlerCreateUser.run(commandUser);
    }
}