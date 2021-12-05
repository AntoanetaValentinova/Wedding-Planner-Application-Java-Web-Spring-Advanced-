package bg.softuni.weedinfplanner.model.binding;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TaskAddBindingModel {
    private String description;

    public TaskAddBindingModel() {

    }

    @NotNull(message = "Description is required!")
    @Size(min=2,max = 100,message = "Description must be between 2 and 100 characters.")
    public String getDescription() {
        return description;
    }

    public TaskAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
