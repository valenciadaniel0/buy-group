package com.buy.group.application.handler.command;

import com.buy.group.domain.model.Department;

public class CommandCity{
    private String name;
    private String code;
    private Department department;

    public CommandCity(String name, String code, Department department){
        this.name = name;
        this.code = code;
        this.department = department;
    }

    public String getName(){
        return this.name;
    }

    public String getCode(){
        return this.code;
    }

    public Department getDepartment(){
        return this.department;
    }

}