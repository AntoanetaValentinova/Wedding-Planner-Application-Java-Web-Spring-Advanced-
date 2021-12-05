package bg.softuni.weedinfplanner.model.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class BudgetUpdateServiceModel {
    private BigDecimal initialBudget;

    public BudgetUpdateServiceModel() {
    }

    public BigDecimal getInitialBudget() {
        return initialBudget;
    }

    public BudgetUpdateServiceModel setInitialBudget(BigDecimal initialBudget) {
        this.initialBudget = initialBudget;
        return this;
    }
}
