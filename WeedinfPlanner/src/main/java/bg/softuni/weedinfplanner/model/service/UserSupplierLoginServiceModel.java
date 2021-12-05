package bg.softuni.weedinfplanner.model.service;

public class UserSupplierLoginServiceModel {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public UserSupplierLoginServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserSupplierLoginServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
