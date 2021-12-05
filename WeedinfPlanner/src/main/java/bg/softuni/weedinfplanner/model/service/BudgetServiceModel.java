package bg.softuni.weedinfplanner.model.service;

import java.math.BigDecimal;

public class BudgetServiceModel {
    private BigDecimal initialBudget;
    private BigDecimal currentBudget;

    public BudgetServiceModel() {
    }

    public BigDecimal getInitialBudget() {
        return initialBudget;
    }

    public BudgetServiceModel setInitialBudget(BigDecimal initialBudget) {
        this.initialBudget = initialBudget;
        return this;
    }

    public BigDecimal getCurrentBudget() {
        return currentBudget;
    }

    public BudgetServiceModel setCurrentBudget(BigDecimal currentBudget) {
        this.currentBudget = currentBudget;
        return this;
    }
}
