package com.buy.group.framework.adapter.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.buy.group.domain.model.City;
import com.buy.group.framework.entity.EntityCity;

public class MapperCity {
    public static EntityCity modelToEntity(City city) {
        return new EntityCity(city.getName(), city.getCode(), MapperDepartment.modelToEntity(city.getDepartment()));
    }

    public static List<EntityCity> modelsListToEntitiesList(List<City> cities) {
        if (cities == null)
            return null;
        return cities.stream().map(city -> MapperCity.modelToEntity(city)).collect(Collectors.toList());
    }
}