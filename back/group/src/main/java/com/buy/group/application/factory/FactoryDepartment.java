package com.buy.group.application.factory;

import com.buy.group.application.handler.command.CommandDepartment;
import com.buy.group.domain.model.Department;

public class FactoryDepartment {

    private FactoryDepartment() {
        throw new IllegalStateException("Utility class");
    }

    public static Department create(CommandDepartment commandDepartment){
        return new Department(commandDepartment.getId(), commandDepartment.getCode(), commandDepartment.getName(), commandDepartment.getCities());
    }
}