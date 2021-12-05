package bg.softuni.weedinfplanner.model.view;

public class BrideAndGroomNamesViewModel {
    private String firstName;
    private String lastName;
    private String partnerFirstName;
    private String partnerLastName;

    public BrideAndGroomNamesViewModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public BrideAndGroomNamesViewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public BrideAndGroomNamesViewModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPartnerFirstName() {
        return partnerFirstName;
    }

    public BrideAndGroomNamesViewModel setPartnerFirstName(String partnerFirstName) {
        this.partnerFirstName = partnerFirstName;
        return this;
    }

    public String getPartnerLastName() {
        return partnerLastName;
    }

    public BrideAndGroomNamesViewModel setPartnerLastName(String partnerLastName) {
        this.partnerLastName = partnerLastName;
        return this;
    }
}
