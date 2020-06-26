package com.buy.group.application.handler.users;

import com.buy.group.domain.service.users.ServiceUpdateRecoverCode;

import org.springframework.stereotype.Component;

@Component
public class HandlerUpdateRecoverCode {
    private ServiceUpdateRecoverCode updateRecoverCodeService;

    public HandlerUpdateRecoverCode(ServiceUpdateRecoverCode updateRecoverCodeService) {
        this.updateRecoverCodeService = updateRecoverCodeService;
    }

    public void run(String email) {
        this.updateRecoverCodeService.run(email);
    }
}