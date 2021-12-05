package bg.softuni.weedinfplanner.model.service;

import java.math.BigDecimal;

public class ExpenseAddServiceModel {
    private String name;
    private BigDecimal price;
    private BigDecimal paid;

    public ExpenseAddServiceModel() {
    }

    public String getName() {
        return name;
    }

    public ExpenseAddServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ExpenseAddServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getPaid() {
        return paid;
    }

    public ExpenseAddServiceModel setPaid(BigDecimal paid) {
        this.paid = paid;
        return this;
    }
}
