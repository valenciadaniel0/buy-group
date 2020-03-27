package com.buy.group.framework.adapter.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.buy.group.domain.model.Company;
import com.buy.group.framework.entity.EntityCompany;

public class MapperCompany {
    public static EntityCompany modelToEntity(Company company) {
        return new EntityCompany(company.getNit(), company.getAddress(), company.getRate(),
                MapperUser.modelToEntity(company.getUser()));
    }

    public static List<EntityCompany> modelsListToEntitiesList(List<Company> companies) {
        if (companies == null)
            return null;
        return companies.stream().map(company -> MapperCompany.modelToEntity(company)).collect(Collectors.toList());
    }
}