package bg.softuni.weedinfplanner.service.impl;

import bg.softuni.weedinfplanner.model.entity.Expense;
import bg.softuni.weedinfplanner.model.service.ExpenseUpdateServiceModel;
import bg.softuni.weedinfplanner.repository.ExpenseRepository;
import bg.softuni.weedinfplanner.service.ExpenseService;
import bg.softuni.weedinfplanner.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository, ModelMapper modelMapper) {
        this.expenseRepository = expenseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Expense> findAllInitialExpenses() {
        return this.expenseRepository.findAllByInitial(true);
    }

    @Override
    public Expense save(Expense expenseForCurrentUser) {
        return this.expenseRepository.save(expenseForCurrentUser);
    }

    @Override
    public List<ExpenseUpdateServiceModel> findAllExpensesForCurrentUser(Principal principal) {
       return this.expenseRepository.findAllByBudget_Wedding_User_Email(principal.getName())
                .stream()
                .map(expense -> this.modelMapper.map(expense, ExpenseUpdateServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void updateExpense(Long id,ExpenseUpdateServiceModel expenseUpdateServiceModel) {
        Expense expense = this.expenseRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());
        expense.setPrice(expenseUpdateServiceModel.getPrice());
        expense.setPaid(expenseUpdateServiceModel.getPaid());
        expense.setName(expenseUpdateServiceModel.getName());
        this.expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Long id) {
        this.expenseRepository.deleteById(id);
    }

    @Override
    public Expense getExpenseById(Long id) {
        return this.expenseRepository.findById(id).orElse(null);
    }
}
