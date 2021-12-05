package bg.softuni.weedinfplanner.model.view;

import java.math.BigDecimal;

public class BudgetViewModel {
    private BigDecimal initialBudget;
    private BigDecimal currentBudget;

    public BudgetViewModel() {
    }

    public BigDecimal getInitialBudget() {
        return initialBudget;
    }

    public BudgetViewModel setInitialBudget(BigDecimal initialBudget) {
        this.initialBudget = initialBudget;
        return this;
    }

    public BigDecimal getCurrentBudget() {
        return currentBudget;
    }

    public BudgetViewModel setCurrentBudget(BigDecimal currentBudget) {
        this.currentBudget = currentBudget;
        return this;
    }
}
