package com.buy.group.framework.adapter.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.buy.group.domain.model.Company;
import com.buy.group.framework.entity.EntityCompany;

import org.modelmapper.ModelMapper;

public class MapperCompany {
    public static EntityCompany modelToEntity(Company company) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(company, EntityCompany.class);
    }

    public static List<EntityCompany> modelsListToEntitiesList(List<Company> companies) {
        if (companies == null)
            return null;
        return companies.stream().map(company -> MapperCompany.modelToEntity(company)).collect(Collectors.toList());
    }
}