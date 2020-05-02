package com.buy.group.framework.db_repository;

import com.buy.group.framework.entity.EntityCity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDBRepository extends JpaRepository<EntityCity,Long>{

}