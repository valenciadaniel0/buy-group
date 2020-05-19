package com.buy.group.domain.service.users;

import com.buy.group.domain.model.User;
import com.buy.group.domain.port.RepositoryUser;

public class ServiceGetUserByEmail {
    private RepositoryUser repositoryUser;

    public ServiceGetUserByEmail(RepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    public User run(String email) {        
        return this.repositoryUser.findByEmail(email);
    }
}