package bg.softuni.weedinfplanner.model.view;

import java.math.BigDecimal;

public class ExpenseViewModel {
    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal paid;

    public ExpenseViewModel() {
    }

    public Long getId() {
        return id;
    }

    public ExpenseViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ExpenseViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ExpenseViewModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getPaid() {
        return paid;
    }

    public ExpenseViewModel setPaid(BigDecimal paid) {
        this.paid = paid;
        return this;
    }
}
