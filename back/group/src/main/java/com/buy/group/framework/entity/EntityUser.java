package com.buy.group.framework.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="users")
public class EntityUser{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username", nullable = false)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name = "deviceToken")
    private String deviceToken;

    @Column(name="name", nullable = false)
    private String name;   
    
    @Column(name="active", nullable = false)
    private boolean active;  

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id")
	@JsonIgnore
    private EntityCity city;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns
            = @JoinColumn(name = "user_id",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",
                    referencedColumnName = "id"))
    private List<EntityRole> roles;

    public EntityUser(String username, String password, String deviceToken, String name, boolean active, EntityCity city) {
        this.username = username;
        this.password = password;
        this.deviceToken = deviceToken;
        this.name = name;
        this.active = active;
        this.city = city;        
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDeviceToken() {
        return this.deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public EntityCity getCity() {
        return this.city;
    }

    public void setCity(EntityCity city) {
        this.city = city;
    }    

    public List<EntityRole> getRoles(){
        return this.roles;
    }
}