package bg.softuni.weedinfplanner.service.impl;

import bg.softuni.weedinfplanner.model.entity.Budget;
import bg.softuni.weedinfplanner.model.entity.Expense;
import bg.softuni.weedinfplanner.model.service.BudgetServiceModel;
import bg.softuni.weedinfplanner.model.service.BudgetUpdateServiceModel;
import bg.softuni.weedinfplanner.model.service.ExpenseAddServiceModel;
import bg.softuni.weedinfplanner.model.service.ExpenseUpdateServiceModel;
import bg.softuni.weedinfplanner.repository.BudgetRepository;
import bg.softuni.weedinfplanner.service.BudgetService;
import bg.softuni.weedinfplanner.service.ExpenseService;
import bg.softuni.weedinfplanner.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;

@Service
public class BudgetServiceImpl implements BudgetService {
    private final BudgetRepository budgetRepository;
    private final ModelMapper modelMapper;
    private final ExpenseService expenseService;


    public BudgetServiceImpl(BudgetRepository budgetRepository, ModelMapper modelMapper, ExpenseService expenseService) {
        this.budgetRepository = budgetRepository;
        this.modelMapper = modelMapper;
        this.expenseService = expenseService;
    }

    @Override
    public Budget save(Budget budget) {
        return this.budgetRepository.save(budget);
    }

    @Override
    public void addExpense(ExpenseAddServiceModel expenseAddServiceModel, Principal principal) {
        //get budget of the current user
        Budget budget = this.budgetRepository.findBudgetByWedding_User_Email(principal.getName())
                .orElseThrow(() -> new ObjectNotFoundException());
        //check if there is a paid field and reduce the current budget if yes
        if (expenseAddServiceModel.getPaid().compareTo(BigDecimal.valueOf(0L)) > 0) {
            reduceCurrentBudget(budget, expenseAddServiceModel.getPaid());
        }
        Expense expense = this.modelMapper.map(expenseAddServiceModel, Expense.class);
        expense.setBudget(budget);
        this.expenseService.save(expense);
    }


    @Override
    public BudgetServiceModel getBudget(Principal principal) {
        Budget budget = this.budgetRepository.findBudgetByWedding_User_Email(principal.getName())
                .orElseThrow(() -> new ObjectNotFoundException());
        return this.modelMapper.map(budget, BudgetServiceModel.class);
    }

    @Override
    public void deleteExpense(Long id) {
        Expense expense = this.expenseService.getExpenseById(id);
        if (expense.getPaid().compareTo(BigDecimal.valueOf(0)) > 0) {
            increaseCurrentBudget(expense.getBudget(), expense.getPaid());
        }
        this.expenseService.deleteExpense(id);
    }




    @Override
    public boolean checkIfCurrentBudgetIsEnough(BigDecimal paid, Principal principal) {
        Budget budget = this.budgetRepository.findBudgetByWedding_User_Email(principal.getName())
                .orElseThrow(() -> new ObjectNotFoundException());
        BigDecimal currentBudget = budget.getCurrentBudget();
        if (paid.compareTo(currentBudget) > 0) {
            return false;
        }
        return true;
    }

    @Override
    public void updateExpense(Long id, ExpenseUpdateServiceModel expenseUpdateServiceModel, Principal principal) {
        Budget budget = this.budgetRepository.findBudgetByWedding_User_Email(principal.getName())
                .orElseThrow(() -> new ObjectNotFoundException());
        Expense expenseById = this.expenseService.getExpenseById(id);
        //check if paid price is updated
        //if yes and value is higher than the last one -> reduce budget with the diff
        if(expenseUpdateServiceModel.getPaid().compareTo(expenseById.getPaid())>0) {
            BigDecimal diff = expenseUpdateServiceModel.getPaid().subtract(expenseById.getPaid());
            reduceCurrentBudget(budget, diff);
        } else if(expenseUpdateServiceModel.getPaid().compareTo(expenseById.getPaid())<0) {
            BigDecimal diff= expenseById.getPaid().subtract(expenseUpdateServiceModel.getPaid());
            increaseCurrentBudget(budget, diff);
        }
        //if yes and value is lower than the last one -> increase budget with the diff
        //update expense
        this.expenseService.updateExpense(id, expenseUpdateServiceModel);

    }

    @Override
    public void updateBudget(BudgetUpdateServiceModel budgetUpdateServiceModel, Principal principal) {
        Budget budget = this.budgetRepository.findBudgetByWedding_User_Email(principal.getName())
                 .orElseThrow(() -> new ObjectNotFoundException());
        BigDecimal lastSavedInitialBudget = budget.getInitialBudget();
        budget.setInitialBudget(budgetUpdateServiceModel.getInitialBudget());
        BigDecimal diff = lastSavedInitialBudget.subtract(budgetUpdateServiceModel.getInitialBudget());
        budget.setCurrentBudget(budget.getCurrentBudget().subtract(diff));
        this.budgetRepository.save(budget);
    }

    private void reduceCurrentBudget(Budget budget, BigDecimal paid) {
        BigDecimal reducedCurrentBudget = budget.getCurrentBudget().subtract(paid);
        budget.setCurrentBudget(reducedCurrentBudget);
        Budget reducedBudget = this.budgetRepository.save(budget);
    }

    private void increaseCurrentBudget(Budget budget, BigDecimal paid) {
        BigDecimal increasedCurrentBudget = budget.getCurrentBudget().add(paid);
        budget.setCurrentBudget(increasedCurrentBudget);
        Budget increasedBudget = this.budgetRepository.save(budget);
    }
}
