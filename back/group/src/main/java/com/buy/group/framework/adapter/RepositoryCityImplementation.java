package com.buy.group.framework.adapter;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.buy.group.domain.model.City;
import com.buy.group.domain.port.RepositoryCity;
import com.buy.group.framework.adapter.mapper.MapperCity;
import com.buy.group.framework.db_repository.CityDBRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositoryCityImplementation implements RepositoryCity {
    private CityDBRepository cityDBRepository;
    private ModelMapper modelMapper;

    public RepositoryCityImplementation(CityDBRepository cityDBRepository) {
        this.cityDBRepository = cityDBRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public void save(City city) {
        this.cityDBRepository.save(MapperCity.modelToEntity(city));
    }

    @Override
    public ArrayList<City> findAll() {
        return (ArrayList<City>) this.cityDBRepository.findAll().stream()
                .map(city -> this.modelMapper.map(city, City.class)).collect(Collectors.toList());
    }
}