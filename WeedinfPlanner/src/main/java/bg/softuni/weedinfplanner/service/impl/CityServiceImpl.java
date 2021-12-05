package bg.softuni.weedinfplanner.service.impl;

import bg.softuni.weedinfplanner.model.entity.City;
import bg.softuni.weedinfplanner.repository.CityRepository;
import bg.softuni.weedinfplanner.service.CityService;
import bg.softuni.weedinfplanner.service.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    @Override
    public List<City> getAllCities() {
        return this.cityRepository.findByOrderByName();
    }

    @Override
    public City findByName(String name) {
        return this.cityRepository.findByName(name).orElseThrow(() -> new ObjectNotFoundException());
    }
}
