package com.buy.group.domain.model;

import java.math.BigDecimal;

public class Company extends User{    

    private String nit;
    private String address;
    private BigDecimal rate;    

    public Company(Long id, String username, String password, String deviceToken, String name, boolean active,
            City city, Role role,String nit, String address, BigDecimal rate) {
        super(id, username, password, deviceToken, name, active, city, role);
        this.nit = nit;
        this.address = address;
        this.rate = rate;
    }
}