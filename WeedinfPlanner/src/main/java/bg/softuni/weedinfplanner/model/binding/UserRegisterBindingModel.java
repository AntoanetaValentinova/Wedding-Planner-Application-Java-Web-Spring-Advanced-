package bg.softuni.weedinfplanner.model.binding;

import bg.softuni.weedinfplanner.model.binding.validation.MatchPasswords;
import bg.softuni.weedinfplanner.model.binding.validation.UniqueEmail;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@MatchPasswords
public class UserRegisterBindingModel {
    private String email;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String lastName;
    private LocalDate date;
    private BigDecimal initialBudget;

    @Email
    @NotBlank(message = "Please, enter your email!")
    @UniqueEmail
    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotBlank(message = "Please, enter password!")
    @Size(min = 6, max = 25, message = "Password must be between 6 and 25 characters!")
    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotBlank(message = "Please, enter password!")
    @Size(min = 6, max = 25, message = "Password must be between 2 and 25 characters!")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @NotBlank(message = "Please, enter your first name!")
    @Size(min = 2, max = 25, message = "First name must be between 2 and 25 characters!")
    public String getFirstName() {
        return firstName;
    }

    public UserRegisterBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @NotBlank(message = "Please, enter your last name!")
    @Size(min = 2, max = 25, message = "Last name must be between 2 and 25 characters!")
    public String getLastName() {
        return lastName;
    }

    public UserRegisterBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Date cannot be in the past.")
    public LocalDate getDate() {
        return date;
    }

    public UserRegisterBindingModel setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    @NotNull(message = "Initial budget is required!")
    @Positive(message = "Budget must be positive number.")
    public BigDecimal getInitialBudget() {
        return initialBudget;
    }

    public UserRegisterBindingModel setInitialBudget(BigDecimal initialBudget) {
        this.initialBudget = initialBudget;
        return this;
    }

    @Override
    public String toString() {
        return "RegisterUserBingingModel{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
