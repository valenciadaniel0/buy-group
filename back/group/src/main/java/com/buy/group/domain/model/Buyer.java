package com.buy.group.domain.model;

import java.math.BigDecimal;

public class Buyer {
    private static final String ID_NUMBER_IS_REQUIRED = "Identification number is required";

    private Long id;
    private String address;
    private String idNumber;
    private BigDecimal rate;
    private User user;

    public Buyer(Long id,String address, String idNumber, BigDecimal rate, User user) {
        this.validateAttributes(idNumber);
        this.id = id;
        this.address = address;
        this.idNumber = idNumber;
        this.rate = rate;
        this.user = user;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdNumber() {
        return this.idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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

    private void validateAttributes(String idNumber) {
        DataValidator.validateNull(idNumber, Buyer.ID_NUMBER_IS_REQUIRED);
    }

}