package bg.softuni.weedinfplanner.model.service;

import java.math.BigDecimal;

public class ExpenseUpdateServiceModel {
    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal paid;
    private Long budgetId;

    public ExpenseUpdateServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ExpenseUpdateServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ExpenseUpdateServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ExpenseUpdateServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getPaid() {
        return paid;
    }

    public ExpenseUpdateServiceModel setPaid(BigDecimal paid) {
        this.paid = paid;
        return this;
    }

    public Long getBudgetId() {
        return budgetId;
    }

    public ExpenseUpdateServiceModel setBudgetId(Long budgetId) {
        this.budgetId = budgetId;
        return this;
    }
}
