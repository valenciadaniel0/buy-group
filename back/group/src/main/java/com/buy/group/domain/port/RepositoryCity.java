package com.buy.group.domain.port;

import java.util.ArrayList;

import com.buy.group.domain.model.City;

public interface RepositoryCity {
    void save(City city);
    ArrayList<City> findAll();
}