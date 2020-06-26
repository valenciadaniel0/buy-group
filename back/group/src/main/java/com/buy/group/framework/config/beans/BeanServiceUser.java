package com.buy.group.framework.config.beans;

import com.buy.group.domain.port.RepositoryUser;
import com.buy.group.domain.service.users.ServiceCreateUser;
import com.buy.group.domain.service.users.ServiceGetUserByEmail;
import com.buy.group.domain.service.users.ServiceRecoverPassword;
import com.buy.group.domain.service.users.ServiceUpdatePassword;
import com.buy.group.domain.service.users.ServiceUpdateRecoverCode;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServiceUser {
    @Bean
    public ServiceCreateUser serviceCreateUser(RepositoryUser repositoryUser) {
        return new ServiceCreateUser(repositoryUser);
    }

    @Bean
    public ServiceGetUserByEmail serviceGetUserByEmail(RepositoryUser repositoryUser) {
        return new ServiceGetUserByEmail(repositoryUser);
    }

    @Bean
    public ServiceUpdatePassword serviceUpdatePassword(RepositoryUser repositoryUser) {
        return new ServiceUpdatePassword(repositoryUser);
    }

    @Bean
    public ServiceRecoverPassword serviceRecoverPassword(RepositoryUser repositoryUser) {
        return new ServiceRecoverPassword(repositoryUser);
    }

    @Bean
    public ServiceUpdateRecoverCode serviceUpdateRecoverCode(RepositoryUser repositoryUser) {
        return new ServiceUpdateRecoverCode(repositoryUser);
    }
}