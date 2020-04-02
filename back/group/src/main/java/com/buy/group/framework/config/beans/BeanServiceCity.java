package com.buy.group.framework.config.beans;

import com.buy.group.domain.port.RepositoryCity;
import com.buy.group.domain.service.cities.ServiceCreateCity;
import com.buy.group.domain.service.cities.ServiceGetAllCities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServiceCity {
    @Bean
    public ServiceCreateCity serviceCreateCity(RepositoryCity repositoryCity) {
        return new ServiceCreateCity(repositoryCity);
    }

    @Bean
    public ServiceGetAllCities serviceGetAllCities(RepositoryCity repositoryCity) {
        return new ServiceGetAllCities(repositoryCity);
    }
}