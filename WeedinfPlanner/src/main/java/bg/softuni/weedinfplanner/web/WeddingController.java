package bg.softuni.weedinfplanner.web;

import bg.softuni.weedinfplanner.model.binding.WeddingDateBindingModel;
import bg.softuni.weedinfplanner.model.entity.enums.AttendEnum;
import bg.softuni.weedinfplanner.model.service.OffersAllServiceModel;
import bg.softuni.weedinfplanner.model.service.WeddingDateServiceModel;
import bg.softuni.weedinfplanner.model.view.BudgetViewModel;
import bg.softuni.weedinfplanner.model.view.OffersAllViewModel;
import bg.softuni.weedinfplanner.model.view.TaskViewModel;
import bg.softuni.weedinfplanner.service.BudgetService;
import bg.softuni.weedinfplanner.service.GuestService;
import bg.softuni.weedinfplanner.service.TaskService;
import bg.softuni.weedinfplanner.service.WeddingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WeddingController {

    private final WeddingService weddingService;
    private final GuestService guestService;
    private final ModelMapper modelMapper;
    private final BudgetService budgetService;
    private final TaskService taskService;

    public WeddingController(WeddingService weddingService, GuestService guestService, ModelMapper modelMapper, BudgetService budgetService, TaskService taskService) {
        this.weddingService = weddingService;
        this.guestService = guestService;
        this.modelMapper = modelMapper;
        this.budgetService = budgetService;
        this.taskService = taskService;
    }


    @GetMapping("/wedding")
    public String wedding(Model model, Principal principal) {
        BudgetViewModel budgetViewModel = this.modelMapper.map(this.budgetService.getBudget(principal), BudgetViewModel.class);
        LocalDate weddingDate = this.weddingService.getWeddingDateForCurrentUser(principal);
        Long allAttending
                = this.guestService.findCountOfGuestsByAttendanceForCurrentUser(principal, AttendEnum.ATTENDING);
        Long allDeclined
                = this.guestService.findCountOfGuestsByAttendanceForCurrentUser(principal, AttendEnum.DECLINED);
        Long allPending
                = this.guestService.findCountOfGuestsByAttendanceForCurrentUser(principal, AttendEnum.PENDING);
        List<OffersAllViewModel> allFavouriteOffers = this.weddingService.getAllFavouriteOffers(principal)
                .stream()
                .map(offersAllServiceModel -> this.modelMapper.map(offersAllServiceModel, OffersAllViewModel.class))
                .collect(Collectors.toList());
        List<OffersAllViewModel> allHired = this.weddingService.getAllHired(principal)
                .stream()
                .map(offersAllServiceModel -> this.modelMapper.map(offersAllServiceModel, OffersAllViewModel.class))
                .collect(Collectors.toList());

        model.addAttribute("countCompleted", this.taskService.findCountOfAllCompletedTasks(principal));
        model.addAttribute("countAll", this.taskService.getCountOfAllTaskForCurrentUser(principal));
        model.addAttribute("weddingDate", weddingDate);
        model.addAttribute("allAttending", allAttending);
        model.addAttribute("allDeclined", allDeclined);
        model.addAttribute("allPending", allPending);
        model.addAttribute("budget", budgetViewModel);
        model.addAttribute("favouriteOffers", allFavouriteOffers);
        model.addAttribute("allHired", allHired);
        return "wedding";
    }

    @PatchMapping("/wedding/add-favourite")
    public String addToFavourite(@RequestParam(name = "offer") Long offerId, Principal principal) {
        this.weddingService.addToFavourite(offerId, principal);
        return "redirect:/wedding";
    }

    @PatchMapping("/wedding/remove-favourite")
    public String removeFromFavourite(@RequestParam(name = "offer") Long offerId, Principal principal) {
        this.weddingService.removeFromFavourite(offerId, principal);
        return "redirect:/wedding";
    }

    @PatchMapping("/wedding/add-hired")
    public String addToHired(@RequestParam(name = "offer") Long offerId, Principal principal) {
        this.weddingService.addToHired(offerId, principal);
        return "redirect:/wedding";
    }

    @PatchMapping("/wedding/remove-hired")
    public String removeFromHired(@RequestParam(name = "offer") Long offerId, Principal principal) {
        this.weddingService.removeFromHired(offerId, principal);
        return "redirect:/wedding";
    }

    //ADD WEDDING DATE
    @ModelAttribute
    public WeddingDateBindingModel weddingDateBindingModel() {
        return new WeddingDateBindingModel();
    }

    @PostMapping("/wedding/add-date")
    public String addDate(@Valid  WeddingDateBindingModel weddingDateBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes,
                          Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addDateHasErrors", true);
            redirectAttributes.addFlashAttribute("weddingDateBindingModel", weddingDateBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.weddingDateBindingModel", bindingResult);
            return "redirect:/wedding";
        }

        WeddingDateServiceModel weddingDateServiceModel = this.modelMapper.map(weddingDateBindingModel, WeddingDateServiceModel.class);
        this.weddingService.addWeddingDate(weddingDateServiceModel,principal);
        return "redirect:/wedding";
    }

}
