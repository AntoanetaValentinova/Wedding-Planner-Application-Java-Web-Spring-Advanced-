package bg.softuni.weedinfplanner.model.service;

import bg.softuni.weedinfplanner.model.entity.Picture;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserProfileUpdateServiceModel {
    private String firstName;
    private String lastName;
    private String partnerFirstName;
    private String partnerLastName;

    public UserProfileUpdateServiceModel() {
    }


    public String getFirstName() {
        return firstName;
    }

    public UserProfileUpdateServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserProfileUpdateServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPartnerFirstName() {
        return partnerFirstName;
    }

    public UserProfileUpdateServiceModel setPartnerFirstName(String partnerFirstName) {
        this.partnerFirstName = partnerFirstName;
        return this;
    }

    public String getPartnerLastName() {
        return partnerLastName;
    }

    public UserProfileUpdateServiceModel setPartnerLastName(String partnerLastName) {
        this.partnerLastName = partnerLastName;
        return this;
    }
}
