package bg.softuni.weedinfplanner.model.service;

public class TaskServiceModel {
    private Long id;
    private String description;
    private boolean isCompleted;

    public TaskServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public TaskServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean getCompleted() {
        return isCompleted;
    }

    public TaskServiceModel setCompleted(boolean completed) {
        isCompleted = completed;
        return this;
    }
}
