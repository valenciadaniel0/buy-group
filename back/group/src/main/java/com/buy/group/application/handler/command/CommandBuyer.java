package com.buy.group.application.handler.command;

import java.math.BigDecimal;

import com.buy.group.domain.model.User;

public class CommandBuyer{
    private String address;
    private String idNumber;
    private BigDecimal rate;
    private User user;

    public CommandBuyer(String address, String idNumber, BigDecimal rate, User user) {
        this.address = address;
        this.idNumber = idNumber;
        this.rate = rate;
        this.user = user;
    }

    public String getAddress() {
        return this.address;
    }

    public String getIdNumber() {
        return this.idNumber;
    }

    public BigDecimal getRate() {
        return this.rate;
    }

    public User getUser() {
        return this.user;
    }
}