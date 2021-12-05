package bg.softuni.weedinfplanner.model.service;

public class SupplierProfileUpdateServiceModel {
    private String companyName;
    private String phoneNumber;
    private String address;
    private String cityName;

    public SupplierProfileUpdateServiceModel() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public SupplierProfileUpdateServiceModel setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public SupplierProfileUpdateServiceModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public SupplierProfileUpdateServiceModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCityName() {
        return cityName;
    }

    public SupplierProfileUpdateServiceModel setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }
}
