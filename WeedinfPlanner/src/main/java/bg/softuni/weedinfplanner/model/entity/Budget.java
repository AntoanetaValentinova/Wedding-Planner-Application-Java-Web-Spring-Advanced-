package bg.softuni.weedinfplanner.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "budgets")
public class Budget extends BaseEntity {
    private BigDecimal initialBudget;
    private BigDecimal currentBudget;
    private Set<Expense> expenses;
    private Wedding wedding;

    public Budget() {
        this.currentBudget = this.initialBudget;
    }

    @Column(name = "initial_budget",nullable = false)
    public BigDecimal getInitialBudget() {
        return initialBudget;
    }

    public Budget setInitialBudget(BigDecimal initialBudget) {
        this.initialBudget = initialBudget;
        return this;
    }

    @Column(name = "current_budget")
    public BigDecimal getCurrentBudget() {
        return currentBudget;
    }

    public Budget setCurrentBudget(BigDecimal currentBudget) {
        this.currentBudget = currentBudget;
        return this;
    }

    @OneToMany(mappedBy = "budget",fetch = FetchType.EAGER)
    public Set<Expense> getExpenses() {
        return expenses;
    }

    public Budget setExpenses(Set<Expense> expenses) {
        this.expenses = expenses;
        return this;
    }

    @OneToOne(mappedBy = "budget")
    public Wedding getWedding() {
        return wedding;
    }

    public Budget setWedding(Wedding wedding) {
        this.wedding = wedding;
        return this;
    }
}
