package bg.softuni.weedinfplanner.model.view;

public class TaskViewModel {
    private Long id;
    private String description;
    private boolean isCompleted;

    public TaskViewModel() {
    }

    public Long getId() {
        return id;
    }

    public TaskViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public boolean getCompleted() {
        return isCompleted;
    }

    public TaskViewModel setCompleted(boolean completed) {
        isCompleted = completed;
        return this;
    }
}
