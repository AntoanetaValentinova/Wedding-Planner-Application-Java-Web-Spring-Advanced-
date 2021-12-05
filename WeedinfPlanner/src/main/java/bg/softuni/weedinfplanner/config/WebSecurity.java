package bg.softuni.weedinfplanner.config;

import bg.softuni.weedinfplanner.model.entity.Expense;
import bg.softuni.weedinfplanner.model.entity.Guest;
import bg.softuni.weedinfplanner.model.entity.Offer;
import bg.softuni.weedinfplanner.model.entity.Task;
import bg.softuni.weedinfplanner.service.ExpenseService;
import bg.softuni.weedinfplanner.service.GuestService;
import bg.softuni.weedinfplanner.service.OfferService;
import bg.softuni.weedinfplanner.service.TaskService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class WebSecurity {

    private final OfferService offerService;
    private final ExpenseService expenseService;
    private final TaskService taskService;
    private final GuestService guestService;

    public WebSecurity(OfferService offerService, ExpenseService expenseService, TaskService taskService, GuestService guestService) {
        this.offerService = offerService;
        this.expenseService = expenseService;
        this.taskService = taskService;
        this.guestService = guestService;
    }


    public boolean isOwnerOfOffer(Authentication authentication, Long id) {
        Offer offer=this.offerService.getOfferById(id);

        if (offer.getSupplier().getEmail().equals(authentication.getName())) {
            return true;
        }
        return false;
    }

    public boolean isOwnerOfExpense(Authentication authentication, Long id) {
        Expense expense=this.expenseService.getExpenseById(id);

        if (expense.isInitial() || expense.getBudget().getWedding().getUser().getEmail().equals(authentication.getName())) {
            return true;
        }
        return false;
    }

    public boolean isOwnerOfTask(Authentication authentication, Long id) {
        Task task=this.taskService.getTaskById(id);

        if (task.getWedding().getUser().getEmail().equals(authentication.getName())) {
            return true;
        }
        return false;
    }

    public boolean isOwnerOfGuest(Authentication authentication, Long id) {
        Guest guest=this.guestService.getGuestById(id);

        if (guest!=null && guest.getWeddingToAttend().getUser().getEmail().equals(authentication.getName())) {
            return true;
        }
        return false;
    }


}
