package bg.softuni.weedinfplanner.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SupplierProfileUpdateBindingModel {
    private String companyName;
    private String phoneNumber;
    private String address;
    private String cityName;

    public SupplierProfileUpdateBindingModel() {
    }

    @NotBlank(message = "Company name is required!")
    @Size(min = 2,max=40,message = "Company name must be between 2 and 40 characters long!")
    public String getCompanyName() {
        return companyName;
    }

    public SupplierProfileUpdateBindingModel setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public SupplierProfileUpdateBindingModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @NotBlank(message = "Please, enter address!")
    @Size(min = 2, max = 100, message = "Address must be between 2 and 100 characters!")
    public String getAddress() {
        return address;
    }

    public SupplierProfileUpdateBindingModel setAddress(String address) {
        this.address = address;
        return this;
    }

    @NotNull(message = "Please, select city!")
    public String getCityName() {
        return cityName;
    }

    public SupplierProfileUpdateBindingModel setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }
}
