package com.buy.group.framework.adapter.mapper;

import com.buy.group.domain.model.User;
import com.buy.group.framework.entity.EntityUser;

public class MapperUser {
    public static EntityUser modelToEntity(User user) {
        return new EntityUser(user.getUsername(), user.getEmail(), user.getPassword(), user.getDeviceToken(),
                user.getName(), user.getActive(), MapperCity.modelToEntity(user.getCity()),
                MapperBuyer.modelsListToEntitiesList(user.getBuyers()),
                MapperCompany.modelsListToEntitiesList(user.getCompanies()));
    }
}