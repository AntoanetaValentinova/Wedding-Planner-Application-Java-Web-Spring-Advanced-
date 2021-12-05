package bg.softuni.weedinfplanner.model.binding.validation;

import bg.softuni.weedinfplanner.model.binding.ExpenseUpdateBindingModel;
import bg.softuni.weedinfplanner.model.entity.Budget;
import bg.softuni.weedinfplanner.model.entity.Expense;
import bg.softuni.weedinfplanner.service.BudgetService;
import bg.softuni.weedinfplanner.service.ExpenseService;
import bg.softuni.weedinfplanner.service.exceptions.ObjectNotFoundException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class EnoughBudgetValidator implements ConstraintValidator<EnoughBudget, Object> {
    private final BudgetService budgetService;
    private final ExpenseService expenseService;

    public EnoughBudgetValidator(BudgetService budgetService, ExpenseService expenseService) {
        this.budgetService = budgetService;
        this.expenseService = expenseService;
    }

    @Override
    public void initialize(EnoughBudget constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        boolean isValid = true;
        ExpenseUpdateBindingModel expenseUpdateBindingModel=(ExpenseUpdateBindingModel) obj;
        Expense expense = this.expenseService.getExpenseById(expenseUpdateBindingModel.getId());
        Budget budget = expense.getBudget();
        BigDecimal currentBudget = budget.getCurrentBudget();

        if (expenseUpdateBindingModel.getPaid()!=null &&
                expenseUpdateBindingModel.getPrice()!=null &&
                expenseUpdateBindingModel.getPaid().compareTo(currentBudget) > 0 &&
                expenseUpdateBindingModel.getPaid().compareTo(expense.getPaid())>=0) {
            isValid=false;
        }
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("paid").addConstraintViolation();
        }
        return isValid;
    }
}
