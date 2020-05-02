package com.buy.group.application.handler.command;

import java.math.BigDecimal;

import com.buy.group.domain.model.User;

public class CommandCompany{
    private String nit;
    private String address;
    private BigDecimal rate;
    private User user;

    public CommandCompany(String nit, String address, BigDecimal rate, User user) {
        this.nit = nit;
        this.address = address;
        this.rate = rate;
        this.user = user;
    }

    public String getNit() {
        return this.nit;
    }

    public String getAddress() {
        return this.address;
    }

    public BigDecimal getRate() {
        return this.rate;
    }

    public User getUser() {
        return this.user;
    }
}