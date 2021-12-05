package bg.softuni.weedinfplanner.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserProfileUpdateBindingModel {
    private String firstName;
    private String lastName;
    private String partnerFirstName;
    private String partnerLastName;

    public UserProfileUpdateBindingModel() {
    }


    @NotBlank(message = "Please, enter your first name!")
    @Size(min = 2, max = 25, message = "First name must be between 2 and 25 characters!")
    public String getFirstName() {
        return firstName;
    }

    public UserProfileUpdateBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    @NotBlank(message = "Please, enter your last name!")
    @Size(min = 2, max = 25, message = "Last name must be between 2 and 25 characters!")
    public String getLastName() {
        return lastName;
    }

    public UserProfileUpdateBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPartnerFirstName() {
        return partnerFirstName;
    }

    public UserProfileUpdateBindingModel setPartnerFirstName(String partnerFirstName) {
        this.partnerFirstName = partnerFirstName;
        return this;
    }

    public String getPartnerLastName() {
        return partnerLastName;
    }

    public UserProfileUpdateBindingModel setPartnerLastName(String partnerLastName) {
        this.partnerLastName = partnerLastName;
        return this;
    }
}
