package bg.softuni.weedinfplanner.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {
    private String description;
    private boolean isCompleted;
    private boolean isInitial;
    private Wedding wedding;

    public Task() {
    }

    @Column(nullable = false)
    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(nullable = false)
    public boolean isCompleted() {
        return isCompleted;
    }

    public Task setCompleted(boolean completed) {
        isCompleted = completed;
        return this;
    }

    @Column(nullable = false)
    public boolean isInitial() {
        return isInitial;
    }

    public Task setInitial(boolean initial) {
        isInitial = initial;
        return this;
    }

    @ManyToOne
    public Wedding getWedding() {
        return wedding;
    }

    public Task setWedding(Wedding wedding) {
        this.wedding = wedding;
        return this;
    }
}
