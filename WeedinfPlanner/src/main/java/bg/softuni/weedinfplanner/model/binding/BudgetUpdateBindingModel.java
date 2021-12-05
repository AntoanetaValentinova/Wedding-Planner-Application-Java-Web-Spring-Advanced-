package bg.softuni.weedinfplanner.model.binding;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class BudgetUpdateBindingModel {
    private BigDecimal initialBudget;

    public BudgetUpdateBindingModel() {
    }

    @NotNull(message = "Budget is required!")
    @PositiveOrZero(message = "Budget must be positive number!")
    public BigDecimal getInitialBudget() {
        return initialBudget;
    }

    public BudgetUpdateBindingModel setInitialBudget(BigDecimal initialBudget) {
        this.initialBudget = initialBudget;
        return this;
    }
}
