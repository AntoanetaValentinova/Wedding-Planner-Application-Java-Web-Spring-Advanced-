package bg.softuni.weedinfplanner.service.impl;

import bg.softuni.weedinfplanner.model.entity.Region;
import bg.softuni.weedinfplanner.repository.RegionRepository;
import bg.softuni.weedinfplanner.service.RegionService;
import bg.softuni.weedinfplanner.service.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }


    @Override
    public List<Region> getAllRegions() {
        return this.regionRepository.findAll();
    }

    @Override
    public Region findRegionByName(String name) {
        return this.regionRepository.findRegionByName(name).orElseThrow(() -> new ObjectNotFoundException());
    }
}
