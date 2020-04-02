package com.buy.group.framework.controller;

import com.buy.group.application.handler.command.CommandDepartment;
import com.buy.group.application.handler.departments.HandlerCreateDepartment;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departments")
public class ControllerDepartment{
    private HandlerCreateDepartment handlerCreateDepartment;

    public ControllerDepartment(HandlerCreateDepartment handlerCreateDepartment){
        this.handlerCreateDepartment = handlerCreateDepartment;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void create(@RequestBody CommandDepartment commandDepartment){        
        this.handlerCreateDepartment.run(commandDepartment);
    }
}