package bg.softuni.weedinfplanner.repository;

import bg.softuni.weedinfplanner.model.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {

    List<Expense> findAllByInitial(boolean initial);

    List<Expense> findAllByBudget_Wedding_User_Email(String email);
}
