package bg.softuni.weedinfplanner.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PartnerNamesAddBindingModel {
    private String partnerFirstName;
    private String partnerLastName;

    public PartnerNamesAddBindingModel() {
    }

    @NotBlank(message = "Please, enter your partner first name!")
    @Size(min = 2, max = 25, message = "First name must be between 2 and 25 characters!")
    public String getPartnerFirstName() {
        return partnerFirstName;
    }

    public PartnerNamesAddBindingModel setPartnerFirstName(String partnerFirstName) {
        this.partnerFirstName = partnerFirstName;
        return this;
    }

    @NotBlank(message = "Please, enter your partner last name!")
    @Size(min = 2, max = 25, message = "Last name must be between 2 and 25 characters!")
    public String getPartnerLastName() {
        return partnerLastName;
    }

    public PartnerNamesAddBindingModel setPartnerLastName(String partnerLastName) {
        this.partnerLastName = partnerLastName;
        return this;
    }
}
