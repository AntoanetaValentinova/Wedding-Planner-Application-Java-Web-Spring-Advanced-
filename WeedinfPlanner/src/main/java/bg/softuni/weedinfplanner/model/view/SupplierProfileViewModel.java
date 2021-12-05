package bg.softuni.weedinfplanner.model.view;

import bg.softuni.weedinfplanner.model.entity.Address;

import java.time.LocalDateTime;

public class SupplierProfileViewModel {
    private Long id;
    private String email;
    private LocalDateTime created;
    private String companyName;
    private AddressViewModel address;
    private String phoneNumber;


    public SupplierProfileViewModel() {
    }

    public Long getId() {
        return id;
    }

    public SupplierProfileViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SupplierProfileViewModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public SupplierProfileViewModel setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public SupplierProfileViewModel setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public AddressViewModel getAddress() {
        return address;
    }

    public SupplierProfileViewModel setAddress(AddressViewModel address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public SupplierProfileViewModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
