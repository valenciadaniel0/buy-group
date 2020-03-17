package com.buy.group.application.handler.users;

import com.buy.group.application.factory.FactoryUser;
import com.buy.group.application.handler.command.CommandUser;
import com.buy.group.domain.service.users.ServiceCreateUser;

import org.springframework.stereotype.Component;

@Component
public class HandlerCreateUser {
    private ServiceCreateUser serviceCreateUser;

    public HandlerCreateUser(ServiceCreateUser serviceCreateUser) {
        this.serviceCreateUser = serviceCreateUser;
    }

    public void run(CommandUser commandUser) {

        this.serviceCreateUser.run(FactoryUser.create(commandUser));
    }
}