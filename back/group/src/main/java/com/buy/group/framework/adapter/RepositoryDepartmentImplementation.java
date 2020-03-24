package com.buy.group.framework.adapter;

import com.buy.group.domain.model.Department;
import com.buy.group.domain.port.RepositoryDepartment;
import com.buy.group.framework.adapter.mapper.MapperDepartment;
import com.buy.group.framework.db_repository.DepartmentDBRepository;
import com.buy.group.framework.entity.EntityDepartment;

import org.springframework.stereotype.Repository;

@Repository
public class RepositoryDepartmentImplementation implements RepositoryDepartment {
    private DepartmentDBRepository departmentDBRepository;

    public RepositoryDepartmentImplementation(DepartmentDBRepository departmentDBRepository){
        this.departmentDBRepository = departmentDBRepository;
    }

    @Override
    public void save(Department department) {                       
        this.departmentDBRepository.save(MapperDepartment.modelToEntity(department));
    }    
}