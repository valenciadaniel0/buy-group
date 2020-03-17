package com.buy.group.framework.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "departments")
public class EntityDepartment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "code",nullable = false)
    private String code;

    @OneToMany(mappedBy = "department")
    private List<EntityCity> cities;


    public EntityDepartment(String name, String code, List<EntityCity> cities){
        this.name = name;
        this.code = code;
        this.cities = cities;
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

    public List<EntityCity> getCities(){
        return this.cities;
    }

    public void setCities(List<EntityCity> cities){
        this.cities = cities;
    } 
}