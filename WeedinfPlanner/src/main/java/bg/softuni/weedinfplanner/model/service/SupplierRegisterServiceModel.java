package bg.softuni.weedinfplanner.model.service;

import bg.softuni.weedinfplanner.model.entity.enums.CategorySupplierEnum;

public class SupplierRegisterServiceModel {
    private String email;
    private String password;
    private String companyName;
    private String address;
    private String city;

    public String getEmail() {
        return email;
    }

    public SupplierRegisterServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public SupplierRegisterServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public SupplierRegisterServiceModel setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public SupplierRegisterServiceModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public SupplierRegisterServiceModel setCity(String city) {
        this.city = city;
        return this;
    }


}
