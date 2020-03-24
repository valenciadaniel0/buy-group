package com.buy.group.framework.adapter;

import com.buy.group.domain.model.City;
import com.buy.group.domain.port.RepositoryCity;
import com.buy.group.framework.adapter.mapper.MapperCity;
import com.buy.group.framework.db_repository.CityDBRepository;
import com.buy.group.framework.entity.EntityCity;

import org.springframework.stereotype.Repository;

@Repository
public class RepositoryCityImplementation implements RepositoryCity {
    private CityDBRepository cityDBRepository;

    public RepositoryCityImplementation(CityDBRepository cityDBRepository) {
        this.cityDBRepository = cityDBRepository;
    }

    @Override
    public void save(City city) {          
        this.cityDBRepository.save(MapperCity.modelToEntity(city));
    }
}