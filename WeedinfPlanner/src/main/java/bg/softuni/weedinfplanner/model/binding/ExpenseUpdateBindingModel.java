package bg.softuni.weedinfplanner.model.binding;

import bg.softuni.weedinfplanner.model.binding.validation.EnoughBudget;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@EnoughBudget
public class ExpenseUpdateBindingModel {
    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal paid;
    private Long budgetId;

    public ExpenseUpdateBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public ExpenseUpdateBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    @NotBlank(message = "Name is required!")
    @Size(min=5,max=100,message = "Name must be between 5 and 100 characters!")
    public String getName() {
        return name;
    }

    public ExpenseUpdateBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @NotNull(message = "Price is required!")
    @PositiveOrZero(message = "Price must be a positive number.")
    public BigDecimal getPrice() {
        return price;
    }

    public ExpenseUpdateBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @NotNull(message = "Paid is required!")
    @PositiveOrZero(message = "Paid field must be a positive number.")
    public BigDecimal getPaid() {
        return paid;
    }

    public ExpenseUpdateBindingModel setPaid(BigDecimal paid) {
        this.paid = paid;
        return this;
    }

    public Long getBudgetId() {
        return budgetId;
    }

    public ExpenseUpdateBindingModel setBudgetId(Long budgetId) {
        this.budgetId = budgetId;
        return this;
    }
}
