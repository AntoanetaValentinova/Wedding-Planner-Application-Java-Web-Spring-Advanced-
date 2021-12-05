package bg.softuni.weedinfplanner.repository;

import bg.softuni.weedinfplanner.model.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BudgetRepository extends JpaRepository<Budget,Long> {

    Optional<Budget> findBudgetByWedding_User_Email(String email);

}
