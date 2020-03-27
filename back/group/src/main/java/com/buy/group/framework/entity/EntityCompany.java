package com.buy.group.framework.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "companies")
public class EntityCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nit")
    private String nit;

    @Column(name = "address")
    private String address;

    @Column(name = "rate")
    private BigDecimal rate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private EntityUser user;

    public EntityCompany(String nit, String address, BigDecimal rate, EntityUser user) {
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

    public EntityUser getUser() {
        return this.user;
    }

    public void setUser(EntityUser user) {
        this.user = user;
    }

    public EntityCompany id(Long id) {
        this.id = id;
        return this;
    }

    public EntityCompany nit(String nit) {
        this.nit = nit;
        return this;
    }

    public EntityCompany address(String address) {
        this.address = address;
        return this;
    }

    public EntityCompany rate(BigDecimal rate) {
        this.rate = rate;
        return this;
    }

    public EntityCompany user(EntityUser user) {
        this.user = user;
        return this;
    }

}