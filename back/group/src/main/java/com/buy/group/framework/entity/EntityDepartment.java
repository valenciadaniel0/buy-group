package com.buy.group.framework.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "departments")
public class EntityDepartment{    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "code",nullable = false)    
    private String code;    


    public EntityDepartment(String name, String code){
        this.name = name;
        this.code = code;        
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    } 
    
    public String getCode(){
        return this.code;
    }

    public void setCode(String code){
        this.code = code;
    } 
}