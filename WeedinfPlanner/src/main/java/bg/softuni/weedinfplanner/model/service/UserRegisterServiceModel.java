package bg.softuni.weedinfplanner.model.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserRegisterServiceModel {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate date;
    private BigDecimal initialBudget;


    public String getEmail() {
        return email;
    }

    public UserRegisterServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserRegisterServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserRegisterServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public UserRegisterServiceModel setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public BigDecimal getInitialBudget() {
        return initialBudget;
    }

    public UserRegisterServiceModel setInitialBudget(BigDecimal initialBudget) {
        this.initialBudget = initialBudget;
        return this;
    }
}
