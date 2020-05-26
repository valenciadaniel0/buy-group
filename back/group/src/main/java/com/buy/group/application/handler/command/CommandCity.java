package com.buy.group.application.handler.command;

import com.buy.group.domain.model.Department;

public class CommandCity{
    private Long id;
    private String name;
    private String code;
    private Department department;

    public CommandCity(){        
    }

    public CommandCity(Long id,String name, String code, Department department){
        this.id = id;
        this.name = name;
        this.code = code;
        this.department = department;
    }

    public Long getId(){
        return this.id;
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