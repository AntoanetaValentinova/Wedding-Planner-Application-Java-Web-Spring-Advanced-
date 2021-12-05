package bg.softuni.weedinfplanner.service;

import bg.softuni.weedinfplanner.model.entity.Region;

import java.util.List;

public interface RegionService {

    List<Region> getAllRegions();

    Region findRegionByName(String name);
}
