package com.buy.group.application.handler.users;

import com.buy.group.domain.model.User;
import com.buy.group.domain.service.users.ServiceRecoverPassword;

import org.springframework.stereotype.Component;

@Component
public class HandlerRecoverPassword {
    private ServiceRecoverPassword serviceRecoverPassword;

    public HandlerRecoverPassword(ServiceRecoverPassword serviceRecoverPassword) {
        this.serviceRecoverPassword = serviceRecoverPassword;
    }

    public void run(User user, String recoverCode) {
        this.serviceRecoverPassword.run(user, recoverCode);
    }
}