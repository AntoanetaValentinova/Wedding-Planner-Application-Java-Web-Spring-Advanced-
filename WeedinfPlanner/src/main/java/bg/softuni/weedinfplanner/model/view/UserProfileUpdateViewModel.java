package bg.softuni.weedinfplanner.model.view;

import bg.softuni.weedinfplanner.model.entity.Picture;

public class UserProfileUpdateViewModel {
    private String firstName;
    private String lastName;
    private String partnerFirstName;
    private String partnerLastName;

    public UserProfileUpdateViewModel() {
    }


    public String getFirstName() {
        return firstName;
    }

    public UserProfileUpdateViewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserProfileUpdateViewModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPartnerFirstName() {
        return partnerFirstName;
    }

    public UserProfileUpdateViewModel setPartnerFirstName(String partnerFirstName) {
        this.partnerFirstName = partnerFirstName;
        return this;
    }

    public String getPartnerLastName() {
        return partnerLastName;
    }

    public UserProfileUpdateViewModel setPartnerLastName(String partnerLastName) {
        this.partnerLastName = partnerLastName;
        return this;
    }
}
