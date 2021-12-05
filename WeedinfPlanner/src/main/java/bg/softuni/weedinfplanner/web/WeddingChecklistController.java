package bg.softuni.weedinfplanner.web;

import bg.softuni.weedinfplanner.model.binding.TaskAddBindingModel;
import bg.softuni.weedinfplanner.model.service.TaskAddServiceModel;
import bg.softuni.weedinfplanner.model.view.TaskViewModel;
import bg.softuni.weedinfplanner.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WeddingChecklistController {
    private final TaskService taskService;
    private final ModelMapper modelMapper;

    public WeddingChecklistController(TaskService taskService, ModelMapper modelMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/wedding-checklist")
    public String weddingChecklist(Model model, Principal principal) {
        List<TaskViewModel> taskViewModels = this.taskService.getCurrentUserAllTasks(principal)
                .stream()
                .map(taskServiceModel -> this.modelMapper.map(taskServiceModel, TaskViewModel.class))
                .collect(Collectors.toList());
        model.addAttribute("countCompleted",this.taskService.findCountOfAllCompletedTasks(principal));
        model.addAttribute("tasks",taskViewModels);
        return "wedding-checklist";
    }

    //ADD TASK
    @ModelAttribute
    public TaskAddBindingModel taskAddBindingModel () {
        return new TaskAddBindingModel();
    }

    @PostMapping("/wedding-checklist/task/add")
    public String addTask(@Valid TaskAddBindingModel taskAddBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes,
                          Principal principal){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("taskAddBindingModel", taskAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskAddBindingModel", bindingResult);
            return "redirect:/wedding-checklist";
        }

        TaskAddServiceModel taskAddServiceModel = this.modelMapper.map(taskAddBindingModel, TaskAddServiceModel.class);
        this.taskService.addTask(principal,taskAddServiceModel);
        return "redirect:/wedding-checklist";
    }

    //UPDATE COMPLITED FIELD
    @PatchMapping("/wedding-checklist/task/{id}")
    public String completeTask(@PathVariable Long id) {
        this.taskService.updateTask(id);
        return "redirect:/wedding-checklist";
    }

    //DELETE TASK
    @DeleteMapping("/wedding-checklist/{id}")
    public String deleteTask(@PathVariable Long id){
        this.taskService.deleteTask(id);
        return "redirect:/wedding-checklist";
    }
}
