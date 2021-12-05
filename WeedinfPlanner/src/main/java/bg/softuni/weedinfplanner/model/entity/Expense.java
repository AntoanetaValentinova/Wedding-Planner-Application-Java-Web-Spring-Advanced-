package bg.softuni.weedinfplanner.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "expenses")
public class Expense extends BaseEntity {
    private String name;
    private BigDecimal price;
    private BigDecimal paid;
    private boolean isInitial;
    private Budget budget;

    public Expense() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Expense setName(String name) {
        this.name = name;
        return this;
    }

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public Expense setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @Column
    public BigDecimal getPaid() {
        return paid;
    }

    public Expense setPaid(BigDecimal paid) {
        this.paid = paid;
        return this;
    }

    @Column(nullable = false)
    public boolean isInitial() {
        return isInitial;
    }

    public Expense setInitial(boolean initial) {
        isInitial = initial;
        return this;
    }

    @ManyToOne
    public Budget getBudget() {
        return budget;
    }

    public Expense setBudget(Budget budget) {
        this.budget = budget;
        return this;
    }
}
