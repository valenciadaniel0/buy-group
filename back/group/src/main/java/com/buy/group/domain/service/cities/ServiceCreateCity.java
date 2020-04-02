package com.buy.group.domain.service.cities;

import com.buy.group.domain.model.City;
import com.buy.group.domain.port.RepositoryCity;

public class ServiceCreateCity {
    private RepositoryCity repositoryCity;

    public ServiceCreateCity(RepositoryCity repositoryCity) {
        this.repositoryCity = repositoryCity;
    }

    public void run(City city) {
        this.repositoryCity.save(city);
    }
}