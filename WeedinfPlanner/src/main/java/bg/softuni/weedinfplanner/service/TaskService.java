package bg.softuni.weedinfplanner.service;

import bg.softuni.weedinfplanner.model.entity.Task;
import bg.softuni.weedinfplanner.model.service.TaskAddServiceModel;
import bg.softuni.weedinfplanner.model.service.TaskServiceModel;

import java.security.Principal;
import java.util.List;

public interface TaskService {
    List<Task> findAllInitialTasks();

    void save(Task task);

    List<TaskServiceModel> getCurrentUserAllTasks(Principal principal);

    void updateTask(Long id);

    void deleteTask(Long id);

    void addTask(Principal principal, TaskAddServiceModel taskAddServiceModel);

    Long findCountOfAllCompletedTasks(Principal principal);

    Long getCountOfAllTaskForCurrentUser(Principal principal);

    Task getTaskById(Long id);
}
