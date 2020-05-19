package com.buy.group.application.handler.users;

import com.buy.group.domain.model.User;
import com.buy.group.domain.service.users.ServiceGetUserByEmail;

import org.springframework.stereotype.Component;

@Component
public class HandlerGetUserByEmail {
    private ServiceGetUserByEmail serviceGetUserByEmail;

    public HandlerGetUserByEmail(ServiceGetUserByEmail serviceGetUserByEmail) {
        this.serviceGetUserByEmail = serviceGetUserByEmail;
    }

    public User run(String email) {        
        return this.serviceGetUserByEmail.run(email);
    }
}