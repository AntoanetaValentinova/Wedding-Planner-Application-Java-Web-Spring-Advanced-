package bg.softuni.weedinfplanner.repository;

import bg.softuni.weedinfplanner.model.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByOrderByName();

    Optional<City> findByName(String name);

}
