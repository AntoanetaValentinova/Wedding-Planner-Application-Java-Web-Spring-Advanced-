package bg.softuni.weedinfplanner.model.binding;

import bg.softuni.weedinfplanner.model.binding.validation.MatchPasswords;
import bg.softuni.weedinfplanner.model.binding.validation.UniqueEmail;
import bg.softuni.weedinfplanner.model.entity.enums.CategorySupplierEnum;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MatchPasswords
public class SupplierRegisterBindingModel {

    private String email;
    private String password;
    private String confirmPassword;
    private String companyName;
    private String address;
    private String city;


    @NotBlank(message = "Please,enter email!")
    @Email(message = "Please, enter valid email!")
    @UniqueEmail
    public String getEmail() {
        return email;
    }

    public SupplierRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotBlank(message = "Please,enter password!")
    @Size(min = 6, max = 25, message = "Password must be between 6 and 25 characters.")
    public String getPassword() {
        return password;
    }

    public SupplierRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @NotBlank(message = "Please,enter confirm password!")
    @Size(min = 6, max = 25, message = "Password must be between 6 and 25 characters.")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public SupplierRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @NotBlank(message = "Please,enter company name!")
    @Size(min = 2, max = 40, message = "Company name must be between 2 and 40 characters.")
    public String getCompanyName() {
        return companyName;
    }

    public SupplierRegisterBindingModel setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    @NotBlank(message = "Please, enter address!")
    @Size(min = 2, max = 100, message = "Address must be between 2 and 100 characters!")
    public String getAddress() {
        return address;
    }

    public SupplierRegisterBindingModel setAddress(String address) {
        this.address = address;
        return this;
    }

    @NotBlank(message = "Please, choose your city!")
    public String getCity() {
        return city;
    }

    public SupplierRegisterBindingModel setCity(String city) {
        this.city = city;
        return this;
    }

}
