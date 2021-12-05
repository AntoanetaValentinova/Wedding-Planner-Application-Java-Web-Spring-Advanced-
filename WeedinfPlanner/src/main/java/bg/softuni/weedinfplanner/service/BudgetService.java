package bg.softuni.weedinfplanner.service;

import bg.softuni.weedinfplanner.model.entity.Budget;
import bg.softuni.weedinfplanner.model.service.BudgetServiceModel;
import bg.softuni.weedinfplanner.model.service.BudgetUpdateServiceModel;
import bg.softuni.weedinfplanner.model.service.ExpenseAddServiceModel;
import bg.softuni.weedinfplanner.model.service.ExpenseUpdateServiceModel;

import java.math.BigDecimal;
import java.security.Principal;

public interface BudgetService {
    Budget save(Budget budget);

    void addExpense(ExpenseAddServiceModel expenseAddServiceModel, Principal principal);

    BudgetServiceModel getBudget(Principal principal);


    void deleteExpense(Long id);

    boolean checkIfCurrentBudgetIsEnough(BigDecimal paid, Principal principal);

    void updateExpense(Long id, ExpenseUpdateServiceModel expenseUpdateServiceModel,Principal principal);

    void updateBudget(BudgetUpdateServiceModel budgetUpdateServiceModel, Principal principal);
}
