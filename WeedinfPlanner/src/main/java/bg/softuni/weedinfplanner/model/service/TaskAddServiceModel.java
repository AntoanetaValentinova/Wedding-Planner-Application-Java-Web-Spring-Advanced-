package bg.softuni.weedinfplanner.model.service;

public class TaskAddServiceModel {
    private String description;

    public TaskAddServiceModel() {

    }

    public String getDescription() {
        return description;
    }

    public TaskAddServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
