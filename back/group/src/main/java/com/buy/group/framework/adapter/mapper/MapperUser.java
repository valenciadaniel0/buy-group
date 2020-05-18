package com.buy.group.framework.adapter.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.buy.group.domain.model.User;
import com.buy.group.framework.entity.EntityUser;

public class MapperUser {
    public static EntityUser modelToEntity(User user) {
        return new EntityUser(user.getUsername(), user.getEmail(), user.getPassword(), user.getDeviceToken(),
                user.getName(), user.getActive(), MapperCity.modelToEntity(user.getCity()),
                MapperRole.modelsListToEntitiesList(user.getRoles()),
                MapperBuyer.modelsListToEntitiesList(user.getBuyers()),
                MapperCompany.modelsListToEntitiesList(user.getCompanies()));
    }

    public static List<EntityUser> modelsListToEntitiesList(List<User> users) {
        if (users == null)
            return null;
        return users.stream().map(user -> MapperUser.modelToEntity(user)).collect(Collectors.toList());
    }
}