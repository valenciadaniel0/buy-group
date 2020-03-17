package com.buy.group.framework.db_repository;

import com.buy.group.framework.entity.EntityUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDBRepository extends JpaRepository<EntityUser, Long>{
    EntityUser findByUsername(String username);   
}