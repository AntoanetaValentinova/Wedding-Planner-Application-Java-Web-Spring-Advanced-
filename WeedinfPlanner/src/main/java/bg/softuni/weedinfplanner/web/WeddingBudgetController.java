package bg.softuni.weedinfplanner.web;
import bg.softuni.weedinfplanner.model.binding.BudgetUpdateBindingModel;
import bg.softuni.weedinfplanner.model.binding.ExpenseAddBindingModel;
import bg.softuni.weedinfplanner.model.binding.ExpenseUpdateBindingModel;
import bg.softuni.weedinfplanner.model.service.BudgetUpdateServiceModel;
import bg.softuni.weedinfplanner.model.service.ExpenseAddServiceModel;
import bg.softuni.weedinfplanner.model.service.ExpenseUpdateServiceModel;
import bg.softuni.weedinfplanner.model.view.BudgetViewModel;
import bg.softuni.weedinfplanner.model.view.ExpenseViewModel;
import bg.softuni.weedinfplanner.service.BudgetService;
import bg.softuni.weedinfplanner.service.ExpenseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WeddingBudgetController {
    private final BudgetService budgetService;
    private final ExpenseService expenseService;
    private final ModelMapper modelMapper;

    public WeddingBudgetController(BudgetService budgetService, ExpenseService expenseService, ModelMapper modelMapper) {
        this.budgetService = budgetService;
        this.expenseService = expenseService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/wedding-budget")
    public String weddingBudget(Model model, Principal principal) {
        if(model.getAttribute("budgetErrors")==null) {
            model.addAttribute("budgetErrors",false);
        }
        if(model.getAttribute("enoughBudget")==null) {
            model.addAttribute("enoughBudget",true);
        }

        List<ExpenseViewModel> expenseViewModels = this.expenseService.findAllExpensesForCurrentUser(principal)
                .stream()
                .map(expenseServiceModel -> this.modelMapper.map(expenseServiceModel, ExpenseViewModel.class))
                .collect(Collectors.toList());
        List<ExpenseUpdateBindingModel> expenseUpdateBindingModels = expenseViewModels
                .stream()
                .map(expenseViewModel -> this.modelMapper.map(expenseViewModel, ExpenseUpdateBindingModel.class))
                .collect(Collectors.toList());
        BudgetViewModel budgetViewModel = this.modelMapper.map(this.budgetService.getBudget(principal), BudgetViewModel.class);
        model.addAttribute("expenseUpdateBindingModels", expenseUpdateBindingModels);
        model.addAttribute("expenseViewModels", expenseViewModels);
        model.addAttribute("budget", budgetViewModel);
        return "wedding-budget";
    }

    //UPDATE BUDGET
    @ModelAttribute
    public BudgetUpdateBindingModel budgetUpdateBindingModel() {
        return new BudgetUpdateBindingModel();
    }

    @PatchMapping("/wedding-budget")
    public String updateBudget(@Valid BudgetUpdateBindingModel budgetUpdateBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("budgetErrors",true);
            redirectAttributes.addFlashAttribute("budgetUpdateBindingModel", budgetUpdateBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.budgetUpdateBindingModel", bindingResult);
            return "redirect:/wedding-budget";
        }
        BudgetUpdateServiceModel budgetUpdateServiceModel = this.modelMapper.map(budgetUpdateBindingModel, BudgetUpdateServiceModel.class);
        this.budgetService.updateBudget(budgetUpdateServiceModel,principal);

        return "redirect:/wedding-budget";
    }

    //ADD EXPENSE
    @ModelAttribute
    public ExpenseAddBindingModel expenseAddBindingModel () {
        return new ExpenseAddBindingModel();
    }

    @PostMapping("/wedding-budget/expense/add")
    public String addExpense(@Valid ExpenseAddBindingModel expenseAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Principal principal) {

        boolean currentBudgetIsEnough = this.budgetService.checkIfCurrentBudgetIsEnough(expenseAddBindingModel.getPaid(), principal);
        if (bindingResult.hasErrors()||!currentBudgetIsEnough) {
            redirectAttributes.addFlashAttribute("enoughBudget",currentBudgetIsEnough);
            redirectAttributes.addFlashAttribute("addErrors",true);
            redirectAttributes.addFlashAttribute("expenseAddBindingModel", expenseAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.expenseAddBindingModel", bindingResult);
            return "redirect:/wedding-budget";
        }

        ExpenseAddServiceModel expenseAddServiceModel = this.modelMapper.map(expenseAddBindingModel, ExpenseAddServiceModel.class);
        this.budgetService.addExpense(expenseAddServiceModel,principal);

        return "redirect:/wedding-budget";
    }

    //DELETE EXPENSE
    @DeleteMapping("/wedding-budget/expense/{id}")
    public String deleteGuest (@PathVariable Long id) {
        this.budgetService.deleteExpense(id);
        return "redirect:/wedding-budget";
    }

    //UPDATE EXPENSE
    @ModelAttribute
    public ExpenseUpdateBindingModel expenseUpdateBindingModel() {
        return new ExpenseUpdateBindingModel();
    }

    @PatchMapping("/wedding-budget/expense/{id}")
    public String updateExpense(@PathVariable Long id,
                                @Valid ExpenseUpdateBindingModel expenseUpdateBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("expenseUpdateBindingModel", expenseUpdateBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.expenseUpdateBindingModel", bindingResult);
            return "redirect:/wedding-budget/expense/{id}/errors";
        }

        ExpenseUpdateServiceModel expenseUpdateServiceModel = this.modelMapper.map(expenseUpdateBindingModel, ExpenseUpdateServiceModel.class);
        this.budgetService.updateExpense(id, expenseUpdateServiceModel,principal);

        return "redirect:/wedding-budget";
    }

    @GetMapping("/wedding-budget/expense/{id}/errors")
    public String updateExpenseErrors(@PathVariable Long id,
                                      Model model,
                                      Principal principal) {
        if(model.getAttribute("enoughBudget")==null) {
            model.addAttribute("enoughBudget",true);
        }
        BudgetViewModel budgetViewModel = this.modelMapper.map(this.budgetService.getBudget(principal), BudgetViewModel.class);
        List<ExpenseViewModel> expenseViewModels = this.expenseService.findAllExpensesForCurrentUser(principal)
                .stream()
                .map(expenseServiceModel -> this.modelMapper.map(expenseServiceModel, ExpenseViewModel.class))
                .collect(Collectors.toList());

        //get list of binding models for each Expense entity
        List<ExpenseUpdateBindingModel> expenseUpdateBindingModels = expenseViewModels
                .stream()
                .map(expenseViewModel -> getExpenseUpdateBindingModel(id, model, principal, expenseViewModel))
                .collect(Collectors.toList());

        model.addAttribute("expenseViewModels", expenseViewModels);
        model.addAttribute("expenseUpdateBindingModels", expenseUpdateBindingModels);
        model.addAttribute("budget",budgetViewModel);
        return "wedding-budget";
    }

    private ExpenseUpdateBindingModel getExpenseUpdateBindingModel(Long id, Model model, Principal principal, ExpenseViewModel expenseViewModel) {
        ExpenseUpdateBindingModel expenseUpdateBindingModel = null;
        //check if the current view model is the needed expense binding model with errors by id
        if (expenseViewModel.getId().equals(id)) {
            //if it is -> map to expenseUpdateBindingModel from Model passed by redirect attributes
            BindingResult bindingResult = (BindingResult) model.getAttribute("org.springframework.validation.BindingResult.expenseUpdateBindingModel");
            model.addAttribute("idError", id);
            //add error attributes for each field so we can show the appropriate messages to the user
            if(bindingResult.hasFieldErrors("name")) {
                model.addAttribute("nameError",bindingResult.getFieldError("name").getDefaultMessage());
            }
            if(bindingResult.hasFieldErrors("price")) {
                model.addAttribute("priceError",bindingResult.getFieldError("price").getDefaultMessage());
            }
            if(bindingResult.hasFieldErrors("paid")) {
                model.addAttribute("paidError",bindingResult.getFieldError("paid").getDefaultMessage());
            }
            expenseUpdateBindingModel = (ExpenseUpdateBindingModel) model.getAttribute("expenseUpdateBindingModel");
            if(bindingResult.hasErrors()) {
                model.addAttribute("hasErrors",true);
            }
        } else {
            //if it`s not just map to ExpenseUpdateBindingModel
            expenseUpdateBindingModel = this.modelMapper.map(expenseViewModel, ExpenseUpdateBindingModel.class);
        }
        return expenseUpdateBindingModel;
    }

}
