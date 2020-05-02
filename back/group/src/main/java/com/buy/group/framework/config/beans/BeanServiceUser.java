package com.buy.group.framework.config.beans;

import com.buy.group.domain.port.RepositoryUser;
import com.buy.group.domain.service.users.ServiceCreateUser;
import com.buy.group.domain.service.users.ServiceGetUserByEmail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServiceUser{
    @Bean
    public ServiceCreateUser serviceCreateUser(RepositoryUser repositoryUser){
        return new ServiceCreateUser(repositoryUser);
    }

    @Bean
    public ServiceGetUserByEmail serviceGetUserByEmail(RepositoryUser repositoryUser){
        return new ServiceGetUserByEmail(repositoryUser);
    }
}