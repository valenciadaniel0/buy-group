package com.buy.group.domain.service.users;

import com.buy.group.domain.model.User;
import com.buy.group.domain.port.RepositoryUser;

public class ServiceCreateUser{
    private RepositoryUser repositoryUser;

    public ServiceCreateUser(RepositoryUser repositoryUser) {
        this.repositoryUser = repositoryUser;
    }

    public void run(User user){
        this.repositoryUser.save(user);
    }
}