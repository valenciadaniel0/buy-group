package com.buy.group.application.handler.command;

public class CommandDepartment {
    private Long id;
    private String code;
    private String name;    
    
    public CommandDepartment(){        
    }

    public CommandDepartment(Long id,String code, String name){
        this.id = id;
        this.code = code;
        this.name = name;        
    }

    public Long getId(){
        return this.id;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }    
}