package bg.softuni.weedinfplanner.service;

import bg.softuni.weedinfplanner.model.entity.Expense;
import bg.softuni.weedinfplanner.model.service.ExpenseUpdateServiceModel;

import java.security.Principal;
import java.util.List;

public interface ExpenseService {

    List<Expense> findAllInitialExpenses();

    Expense save(Expense expenseForCurrentUser);

    List<ExpenseUpdateServiceModel> findAllExpensesForCurrentUser(Principal principal);

    void updateExpense(Long id,ExpenseUpdateServiceModel expenseUpdateServiceModel);

    void deleteExpense(Long id);

    Expense getExpenseById(Long id);
}
