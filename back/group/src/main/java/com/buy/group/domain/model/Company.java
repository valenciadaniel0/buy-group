package com.buy.group.domain.model;

import java.math.BigDecimal;

public class Company{    

    private String nit;
    private String address;
    private BigDecimal rate;   
    private User user; 

    public Company(String nit, String address, BigDecimal rate, User user) {        
        this.nit = nit;
        this.address = address;
        this.rate = rate;
        this.user = user;
    }

    public String getNit(){
        return this.nit;
    }

    public String getAddress(){
        return this.address;
    }

    public BigDecimal getRate(){
        return this.rate;
    }

    public User getUser(){
        return this.user;
    }
}