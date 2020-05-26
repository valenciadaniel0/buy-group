package com.buy.group.application.factory;

import com.buy.group.application.handler.command.CommandCity;
import com.buy.group.domain.model.City;

public class FactoryCity{
    private FactoryCity(){
        throw new IllegalStateException("Utility class");
    }

    public static City create(CommandCity commandCity){
        return new City(commandCity.getId(),commandCity.getName(), commandCity.getCode(), commandCity.getDepartment());
    }
}