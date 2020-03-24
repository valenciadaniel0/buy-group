package com.buy.group.application.handler.cities;

import com.buy.group.application.factory.FactoryCity;
import com.buy.group.application.handler.command.CommandCity;
import com.buy.group.domain.service.cities.ServiceCreateCity;

import org.springframework.stereotype.Component;

@Component
public class HandlerCreateCity{
    ServiceCreateCity serviceCreateCity;

    public HandlerCreateCity(ServiceCreateCity serviceCreateCity){
        this.serviceCreateCity = serviceCreateCity;
    }
    
    public void run(CommandCity commandCity){             
        this.serviceCreateCity.run(FactoryCity.create(commandCity));
    }
}