package bg.softuni.weedinfplanner.web;

import bg.softuni.weedinfplanner.model.entity.enums.RoleEnum;
import bg.softuni.weedinfplanner.model.service.OffersAllServiceModel;
import bg.softuni.weedinfplanner.model.service.StatisticServiceModel;
import bg.softuni.weedinfplanner.model.view.StatisticViewModel;
import bg.softuni.weedinfplanner.model.view.SuppliersAllViewModel;
import bg.softuni.weedinfplanner.model.view.UsersAllViewModel;
import bg.softuni.weedinfplanner.service.OfferService;
import bg.softuni.weedinfplanner.service.StatisticService;
import bg.softuni.weedinfplanner.service.SupplierService;
import bg.softuni.weedinfplanner.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Controller
public class AdminController {
    private final UserService userService;
    private final SupplierService supplierService;
    private final ModelMapper modelMapper;
    private final StatisticService statisticService;
    private final OfferService offerService;

    public AdminController(UserService userService, SupplierService supplierService, ModelMapper modelMapper, StatisticService statisticService, OfferService offerService) {
        this.userService = userService;
        this.supplierService = supplierService;
        this.modelMapper = modelMapper;
        this.statisticService = statisticService;
        this.offerService = offerService;
    }

    //MANAGE USERS PAGE
    @GetMapping("/admin/manage-users")
    public String adminPanel(Model model) {
        List<UsersAllViewModel> usersAllViewModels = this.userService.findAllUsers()
                .stream()
                .map(usersAllServiceModel -> this.modelMapper.map(usersAllServiceModel, UsersAllViewModel.class))
                .collect(Collectors.toList());
        List<SuppliersAllViewModel> suppliersAllViewModels = this.supplierService.findAllSuppliers()
                .stream()
                .map(suppliersAllServiceModel -> this.modelMapper.map(suppliersAllServiceModel, SuppliersAllViewModel.class))
                .collect(Collectors.toList());
        model.addAttribute("allUsers",usersAllViewModels);
        model.addAttribute("allSuppliers",suppliersAllViewModels);
        model.addAttribute("admin", RoleEnum.ADMIN);
        return "admin-manage-users";
    }

    //ADD ADMIN ROLE
    @PatchMapping("/admin/manage-users/add-admin")
    public String makeAdmin(@RequestParam String email){
        boolean isUserExist = this.userService.existByEmail(email);
        boolean isSupplierExist = this.supplierService.existByEmail(email);
        if(isSupplierExist) {
            this.supplierService.makeSupplierAdmin(email);
        } else if(isUserExist) {
            this.userService.makeUserAdmin(email);
        }

        return "redirect:/admin/manage-users";
    }

    //REMOVE ADMIN ROLE
    @PatchMapping("/admin/manage-users/remove-admin")
    public String removeAdmin(@RequestParam String email){
        boolean isUserExist = this.userService.existByEmail(email);
        boolean isSupplierExist = this.supplierService.existByEmail(email);
        if(isSupplierExist) {
            this.supplierService.removeAdminRole(email);
        } else if(isUserExist) {
            this.userService.removeAdminRole(email);
        }

        return "redirect:/admin/manage-users";
    }

    //VIEW STATISTICS
    @GetMapping("/admin/statistics")
    public String statistics(Model model) {
        Map<String, Long> graphData = new TreeMap<>();
        StatisticServiceModel statistic = this.statisticService.getStatistic();
        StatisticViewModel statisticViewModel = this.modelMapper.map(statistic, StatisticViewModel.class);
        getGraphData(graphData, statistic);
        model.addAttribute("chartData", graphData);
        model.addAttribute("statistic",statisticViewModel);
        return "admin-statistics";
    }

    //REVIEW OFFERS
    @GetMapping("/admin/review-offers")
    public String reviewOffers(Model model) {
        List<OffersAllServiceModel> allPendingOffers = this.offerService.getAllPendingOffersServiceModel()
                .stream()
                .map(offersAllServiceModel -> this.modelMapper.map(offersAllServiceModel, OffersAllServiceModel.class))
                .collect(Collectors.toList());
        model.addAttribute("pendingOffers", allPendingOffers);
        return "admin-approve-offers";
    }

    //APPROVE OFFER
    @PatchMapping("/admin/review-offers/approve/{id}")
    public String approveOffer(@PathVariable Long id) {
        this.offerService.approveOffer(id);
        return "redirect:/admin/review-offers";
    }

    @PatchMapping("/admin/review-offers/reject/{id}")
    public String rejectOffer(@PathVariable Long id) {
        this.offerService.rejectOffer(id);
        return "redirect:/admin/review-offers";
    }

    private void getGraphData(Map<String, Long> graphData, StatisticServiceModel statistic) {
        graphData.put("Add offer page", statistic.getAddOfferPageViews());
        graphData.put("All offers page", statistic.getAllOffersPageViews());
        graphData.put("Index page", statistic.getIndexPageViews());
        graphData.put("Login page", statistic.getLoginPageViews());
        graphData.put("Register page", statistic.getRegisterPageViews());
        graphData.put("Wedding page", statistic.getWeddingPageViews());
        graphData.put("Wedding budget page", statistic.getWeddingBudgetPageViews());
        graphData.put("Wedding guests page", statistic.getWeddingGuestsPageViews());
        graphData.put("Wedding checklist page", statistic.getWeddingChecklistPageViews());
        graphData.put("My offers page", statistic.getMyOffersPageViews());
    }

}
