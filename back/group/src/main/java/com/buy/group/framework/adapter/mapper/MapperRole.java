package com.buy.group.framework.adapter.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.buy.group.domain.model.Role;
import com.buy.group.framework.entity.EntityRole;

import org.modelmapper.ModelMapper;

public class MapperRole {
    public static EntityRole modelToEntity(Role role) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(role, EntityRole.class);
    }

    public static List<EntityRole> modelsListToEntitiesList(List<Role> roles) {
        if (roles == null)
            return null;
        return roles.stream().map(role -> MapperRole.modelToEntity(role)).collect(Collectors.toList());
    }
}