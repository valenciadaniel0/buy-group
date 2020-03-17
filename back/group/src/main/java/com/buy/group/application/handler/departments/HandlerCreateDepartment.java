package com.buy.group.application.handler.departments;

import com.buy.group.application.factory.FactoryDepartment;
import com.buy.group.application.handler.command.CommandDepartment;
import com.buy.group.domain.service.departments.ServiceCreateDepartment;

import org.springframework.stereotype.Component;

@Component
public class HandlerCreateDepartment{
    ServiceCreateDepartment serviceCreateDepartment;

    public HandlerCreateDepartment(ServiceCreateDepartment serviceCreateDepartment){
        this.serviceCreateDepartment = serviceCreateDepartment;
    }

    public void run(CommandDepartment commandDepartment){        
        this.serviceCreateDepartment.run(FactoryDepartment.create(commandDepartment));
    }
}