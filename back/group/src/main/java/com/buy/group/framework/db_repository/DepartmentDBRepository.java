package com.buy.group.framework.db_repository;

import com.buy.group.framework.entity.EntityDepartment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDBRepository extends JpaRepository<EntityDepartment,Long>{    
}