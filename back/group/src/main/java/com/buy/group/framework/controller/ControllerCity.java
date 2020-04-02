package com.buy.group.framework.controller;

import java.util.ArrayList;

import com.buy.group.application.handler.cities.HandlerCreateCity;
import com.buy.group.application.handler.cities.HandlerGetAllCities;
import com.buy.group.application.handler.command.CommandCity;
import com.buy.group.domain.model.City;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
public class ControllerCity {
    private HandlerCreateCity handlerCreateCity;
    private HandlerGetAllCities handlerGetAllCities;

    public ControllerCity(HandlerCreateCity handlerCreateCity, HandlerGetAllCities handlerGetAllCities) {
        this.handlerCreateCity = handlerCreateCity;
        this.handlerGetAllCities = handlerGetAllCities;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void create(@RequestBody CommandCity commandCity) {
        this.handlerCreateCity.run(commandCity);
    }

    @GetMapping
    @Cacheable(value="movieFindCache", key="#p0")
    public ArrayList<City> getAll() {
        System.out.println("Getting all the records");
        return this.handlerGetAllCities.run();
    }
}