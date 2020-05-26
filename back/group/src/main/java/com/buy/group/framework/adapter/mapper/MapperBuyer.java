package com.buy.group.framework.adapter.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.buy.group.domain.model.Buyer;
import com.buy.group.framework.entity.EntityBuyer;

import org.modelmapper.ModelMapper;

public class MapperBuyer {
    public static EntityBuyer modelToEntity(Buyer buyer) {        
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(buyer, EntityBuyer.class);
    }

    public static List<EntityBuyer> modelsListToEntitiesList(List<Buyer> buyers) {
        if (buyers == null)
            return null;
        return buyers.stream().map(buyer -> MapperBuyer.modelToEntity(buyer)).collect(Collectors.toList());
    }
}