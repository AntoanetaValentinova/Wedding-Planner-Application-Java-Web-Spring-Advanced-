package bg.softuni.weedinfplanner.model.service;

public class BrideAndGroomNamesServiceModel {
    private String firstName;
    private String lastName;
    private String partnerFirstName;
    private String partnerLastName;

    public BrideAndGroomNamesServiceModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public BrideAndGroomNamesServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public BrideAndGroomNamesServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPartnerFirstName() {
        return partnerFirstName;
    }

    public BrideAndGroomNamesServiceModel setPartnerFirstName(String partnerFirstName) {
        this.partnerFirstName = partnerFirstName;
        return this;
    }

    public String getPartnerLastName() {
        return partnerLastName;
    }

    public BrideAndGroomNamesServiceModel setPartnerLastName(String partnerLastName) {
        this.partnerLastName = partnerLastName;
        return this;
    }
}
