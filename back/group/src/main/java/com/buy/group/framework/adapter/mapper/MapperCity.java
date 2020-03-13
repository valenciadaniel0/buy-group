package com.buy.group.framework.adapter.mapper;

import com.buy.group.domain.model.City;
import com.buy.group.framework.entity.EntityCity;

public class MapperCity{
    public static EntityCity modelToEntity(City city){
        return new EntityCity(city.getName(), MapperDepartment.modelToEntity(city.getDepartment()));
    }
}