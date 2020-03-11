package com.buy.group.domain.model;

import java.math.BigDecimal;

public class Buyer extends User {
    private String address;
    private String idNumber;
    private BigDecimal rate;    

    public Buyer(Long id, String username, String password, String deviceToken, String name, boolean active, City city, Role role, String address, String idNumber,BigDecimal rate) {
        super(id, username, password, deviceToken, name, active, city, role);
        this.address = address;
        this.idNumber = idNumber;
        this.rate = rate;
    }
    
}