package bg.softuni.weedinfplanner.model.service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PartnerNamesAddServiceModel {
    private String partnerFirstName;
    private String partnerLastName;

    public PartnerNamesAddServiceModel() {
    }


    public String getPartnerFirstName() {
        return partnerFirstName;
    }

    public PartnerNamesAddServiceModel setPartnerFirstName(String partnerFirstName) {
        this.partnerFirstName = partnerFirstName;
        return this;
    }

    public String getPartnerLastName() {
        return partnerLastName;
    }

    public PartnerNamesAddServiceModel setPartnerLastName(String partnerLastName) {
        this.partnerLastName = partnerLastName;
        return this;
    }
}
