package com.buy.group.framework.controller;

import com.buy.group.application.handler.cities.HandlerCreateCity;
import com.buy.group.application.handler.command.CommandCity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cities")
public class ControllerCity{
    private HandlerCreateCity handlerCreateCity;

    public ControllerCity(HandlerCreateCity handlerCreateCity){
        this.handlerCreateCity = handlerCreateCity;
    }

    @PostMapping
    public void create(@RequestBody CommandCity commandCity){                
        this.handlerCreateCity.run(commandCity);
    }
}