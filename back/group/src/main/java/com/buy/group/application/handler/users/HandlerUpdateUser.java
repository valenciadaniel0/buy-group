package com.buy.group.application.handler.users;

import com.buy.group.application.factory.FactoryUser;
import com.buy.group.application.handler.command.CommandUser;
import com.buy.group.domain.port.RepositoryUser;

import org.springframework.stereotype.Component;

@Component
public class HandlerUpdateUser {
    private RepositoryUser userRepository;

    public HandlerUpdateUser(RepositoryUser userRepository) {
        this.userRepository = userRepository;
    }

    public void run(CommandUser commandUser) {
        this.userRepository.update(FactoryUser.create(commandUser));
    }
}