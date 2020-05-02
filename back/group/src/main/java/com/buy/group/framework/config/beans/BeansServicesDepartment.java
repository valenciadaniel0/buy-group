package com.buy.group.framework.config.beans;

import com.buy.group.domain.port.RepositoryDepartment;
import com.buy.group.domain.service.departments.ServiceCreateDepartment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansServicesDepartment{
    @Bean
    public ServiceCreateDepartment serviceCreateDepartment(RepositoryDepartment repositoryDepartment){
        return new ServiceCreateDepartment(repositoryDepartment);
    }
}