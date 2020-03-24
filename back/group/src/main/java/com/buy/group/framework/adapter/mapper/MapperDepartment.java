package com.buy.group.framework.adapter.mapper;

import com.buy.group.domain.model.Department;
import com.buy.group.framework.entity.EntityDepartment;

public class MapperDepartment{
    public static EntityDepartment modelToEntity(Department department){
        return new EntityDepartment(department.getName(), department.getCode());
    }
}