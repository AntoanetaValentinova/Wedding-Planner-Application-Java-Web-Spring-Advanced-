package bg.softuni.weedinfplanner.service.impl;

import bg.softuni.weedinfplanner.model.entity.Region;
import bg.softuni.weedinfplanner.repository.RegionRepository;
import bg.softuni.weedinfplanner.service.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class RegionServiceImplTest {

    private Region testRegion;


     RegionServiceImpl regionService;

    @Mock
    public RegionRepository regionRepository;

    @BeforeEach
    void init() {
        regionService=new RegionServiceImpl(regionRepository);
        testRegion=new Region()
                .setName("TestRegion");
    }

    @Test
    void findRegionByName() {
        Mockito.when(this.regionRepository.findRegionByName(testRegion.getName()))
                .thenReturn(Optional.of(testRegion));
        Region regionByName = this.regionService.findRegionByName(testRegion.getName());
        Assertions.assertEquals("TestRegion",regionByName.getName());
    }

    @Test
    void findRegionByNameNotFound() {
       Assertions.assertThrows(ObjectNotFoundException.class,
               ()->this.regionService.findRegionByName("invalidName"));
    }
}