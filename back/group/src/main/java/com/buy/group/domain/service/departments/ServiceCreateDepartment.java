package com.buy.group.domain.service.departments;

import com.buy.group.domain.exception.GeneralException;
import com.buy.group.domain.model.Department;
import com.buy.group.domain.port.RepositoryDepartment;

public class ServiceCreateDepartment {
    private RepositoryDepartment repositoryDepartment;

    public ServiceCreateDepartment(RepositoryDepartment repositoryDepartment) {
        this.repositoryDepartment = repositoryDepartment;
    }

    public void run(Department department) {
        this.repositoryDepartment.save(department);
    }
}