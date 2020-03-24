package com.buy.group.application.handler.command;

public class CommandDepartment {
    private String code;
    private String name;    
    
    public CommandDepartment(){        
    }

    public CommandDepartment(String code, String name){
        this.code = code;
        this.name = name;        
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }    
}