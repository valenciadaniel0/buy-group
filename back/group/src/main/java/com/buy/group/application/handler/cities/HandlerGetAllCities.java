package com.buy.group.application.handler.cities;

import java.util.ArrayList;

import com.buy.group.domain.model.City;
import com.buy.group.domain.service.cities.ServiceGetAllCities;

import org.springframework.stereotype.Component;

@Component
public class HandlerGetAllCities{
    private ServiceGetAllCities serviceGetAllCities;

    public HandlerGetAllCities(ServiceGetAllCities serviceGetAllCities){
        this.serviceGetAllCities = serviceGetAllCities;
    }

    public ArrayList<City> run(){
        return this.serviceGetAllCities.run();
    }
}