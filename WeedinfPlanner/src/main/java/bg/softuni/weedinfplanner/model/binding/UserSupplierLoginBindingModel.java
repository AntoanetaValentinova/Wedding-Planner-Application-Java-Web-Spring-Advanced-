package bg.softuni.weedinfplanner.model.binding;

import bg.softuni.weedinfplanner.model.binding.validation.Registered;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Registered
public class UserSupplierLoginBindingModel {
    private String email;
    private String password;

    @Email
    @NotBlank(message = "Please,enter email!")
    public String getEmail() {
        return email;
    }

    public UserSupplierLoginBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @NotBlank(message = "Please, enter password!")
    @Size(min = 5, max = 25, message = "Password must be between 6 and 25 characters!")
    public String getPassword() {
        return password;
    }

    public UserSupplierLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
