package bg.softuni.weedinfplanner.service;

import bg.softuni.weedinfplanner.model.entity.City;

import java.util.List;

public interface CityService {

    List<City> getAllCities();

    City findByName(String name);
}
