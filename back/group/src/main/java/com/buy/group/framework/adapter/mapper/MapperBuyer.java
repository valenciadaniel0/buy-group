package com.buy.group.framework.adapter.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.buy.group.domain.model.Buyer;
import com.buy.group.framework.entity.EntityBuyer;

public class MapperBuyer{
    public static EntityBuyer modelToEntity(Buyer buyer){
        return new EntityBuyer(buyer.getAddress(), buyer.getIdNumber(), buyer.getRate(), MapperUser.modelToEntity(buyer.getUser()));
    }

    public static List<EntityBuyer> modelsListToEntitiesList(List<Buyer> buyers){
        return buyers.stream().map(buyer -> MapperBuyer.modelToEntity(buyer)).collect(Collectors.toList());        
    }
}