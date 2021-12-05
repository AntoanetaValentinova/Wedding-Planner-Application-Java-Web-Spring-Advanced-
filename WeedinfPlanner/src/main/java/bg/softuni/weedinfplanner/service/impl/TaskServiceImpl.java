package bg.softuni.weedinfplanner.service.impl;

import bg.softuni.weedinfplanner.model.entity.Task;
import bg.softuni.weedinfplanner.model.entity.Wedding;
import bg.softuni.weedinfplanner.model.service.TaskAddServiceModel;
import bg.softuni.weedinfplanner.model.service.TaskServiceModel;
import bg.softuni.weedinfplanner.repository.TaskRepository;
import bg.softuni.weedinfplanner.service.TaskService;
import bg.softuni.weedinfplanner.service.WeddingService;
import bg.softuni.weedinfplanner.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final WeddingService weddingService;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper, WeddingService weddingService) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.weddingService = weddingService;
    }

    @Override
    public List<Task> findAllInitialTasks() {
        return this.taskRepository.findAllByInitial(true);
    }

    @Override
    public void save(Task task) {
        this.taskRepository.save(task);
    }

    @Override
    public List<TaskServiceModel> getCurrentUserAllTasks(Principal principal) {
        return this.taskRepository
                .findAllByWeddingUserEmail(principal.getName())
                .stream()
                .map(task -> this.modelMapper.map(task, TaskServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void updateTask(Long id) {
        Task task = this.taskRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());
        task.setCompleted(!task.isCompleted());
        this.taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        this.taskRepository.deleteById(id);
    }

    @Override
    public void addTask(Principal principal, TaskAddServiceModel taskAddServiceModel) {
        Task task = this.modelMapper.map(taskAddServiceModel, Task.class);
        task.setCompleted(false);
        task.setInitial(false);
        Wedding weddingByUserEmail = this.weddingService.getWeddingByUserEmail(principal.getName());
        task.setWedding(weddingByUserEmail);
        this.taskRepository.save(task);
    }

    @Override
    public Long findCountOfAllCompletedTasks(Principal principal) {
        return this.taskRepository.countAllByCompletedAndWeddingUserEmail(true, principal.getName());
    }

    @Override
    public Long getCountOfAllTaskForCurrentUser(Principal principal) {
        return this.taskRepository.countAllByWeddingUserEmail(principal.getName());
    }

    @Override
    public Task getTaskById(Long id) {
        return this.taskRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());
    }
}
