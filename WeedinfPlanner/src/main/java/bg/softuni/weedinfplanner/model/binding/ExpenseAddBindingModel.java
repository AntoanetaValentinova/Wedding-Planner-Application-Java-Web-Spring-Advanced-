package bg.softuni.weedinfplanner.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ExpenseAddBindingModel {
    private String name;
    private BigDecimal price;
    private BigDecimal paid;

    public ExpenseAddBindingModel() {
    }


    @NotBlank(message = "Name is required!")
    @Size(min=5,max=100,message = "Name must be between 5 and 100 characters!")
    public String getName() {
        return name;
    }

    public ExpenseAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @NotNull(message = "Price is required!")
    @PositiveOrZero(message = "Price must be a positive number.")
    public BigDecimal getPrice() {
        return price;
    }

    public ExpenseAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @PositiveOrZero(message = "Paid field must be a positive number.")
    public BigDecimal getPaid() {
        return paid;
    }

    public ExpenseAddBindingModel setPaid(BigDecimal paid) {
        this.paid = paid;
        return this;
    }
}
