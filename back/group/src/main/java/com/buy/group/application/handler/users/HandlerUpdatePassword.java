package com.buy.group.application.handler.users;

import com.buy.group.domain.model.User;
import com.buy.group.domain.service.users.ServiceUpdatePassword;

import org.springframework.stereotype.Component;

@Component
public class HandlerUpdatePassword {
    private ServiceUpdatePassword updatePasswordService;

    public HandlerUpdatePassword(ServiceUpdatePassword updatePasswordService) {
        this.updatePasswordService = updatePasswordService;
    }

    public void run(User user) {
        this.updatePasswordService.run(user);
    }
}