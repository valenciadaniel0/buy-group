package com.buy.group.application.factory;

import com.buy.group.application.handler.command.CommandUser;
import com.buy.group.domain.model.User;

public class FactoryUser {

    private FactoryUser() {
        throw new IllegalStateException("Utility class");
    }

    public static User create(CommandUser commandUser) {
        return new User(commandUser.getId(), commandUser.getUsername(), commandUser.getEmail(),
                commandUser.getPassword(), commandUser.getDeviceToken(), commandUser.getName(), commandUser.isActive(),
                commandUser.getCity(), commandUser.getRoles());
    }
}