package bg.softuni.weedinfplanner.repository;

import bg.softuni.weedinfplanner.model.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    Optional<Region> findRegionByName(String name);
}
