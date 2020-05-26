package com.buy.group.framework.adapter.mapper;

import com.buy.group.domain.model.Department;
import com.buy.group.framework.entity.EntityDepartment;

import org.modelmapper.ModelMapper;

public class MapperDepartment {
    public static EntityDepartment modelToEntity(Department department) {        
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(department, EntityDepartment.class);
    }
}