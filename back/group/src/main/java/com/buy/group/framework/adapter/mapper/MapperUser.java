package com.buy.group.framework.adapter.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.buy.group.domain.model.User;
import com.buy.group.framework.entity.EntityUser;

import org.modelmapper.ModelMapper;

public class MapperUser {
    public static EntityUser modelToEntity(User user) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, EntityUser.class);
    }

    public static List<EntityUser> modelsListToEntitiesList(List<User> users) {
        if (users == null)
            return null;
        return users.stream().map(user -> MapperUser.modelToEntity(user)).collect(Collectors.toList());
    }
}