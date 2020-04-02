package com.buy.group.domain.service.cities;

import java.util.ArrayList;

import com.buy.group.domain.model.City;
import com.buy.group.domain.port.RepositoryCity;

public class ServiceGetAllCities {
    RepositoryCity repositoryCity;

    public ServiceGetAllCities(RepositoryCity repositoryCity) {
        this.repositoryCity = repositoryCity;
    }

    public ArrayList<City> run() {
        return this.repositoryCity.findAll();
    }
}