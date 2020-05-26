package com.buy.group.domain.model;

import java.math.BigDecimal;

public class Company {

    private Long id;
    private String nit;
    private String address;
    private BigDecimal rate;
    private User user;

    public Company(Long id, String nit, String address, BigDecimal rate, User user) {
        this.id = id;
        this.nit = nit;
        this.address = address;
        this.rate = rate;
        this.user = user;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNit() {
        return this.nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getRate() {
        return this.rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}