package bg.softuni.weedinfplanner.repository;

import bg.softuni.weedinfplanner.model.entity.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic,Long> {
}
