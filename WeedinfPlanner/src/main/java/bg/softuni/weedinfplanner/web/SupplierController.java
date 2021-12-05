package bg.softuni.weedinfplanner.web;

import bg.softuni.weedinfplanner.model.binding.SupplierProfileUpdateBindingModel;
import bg.softuni.weedinfplanner.model.binding.SupplierRegisterBindingModel;
import bg.softuni.weedinfplanner.model.entity.enums.CategorySupplierEnum;
import bg.softuni.weedinfplanner.model.service.SupplierRegisterServiceModel;
import bg.softuni.weedinfplanner.model.view.OffersAllViewModel;
import bg.softuni.weedinfplanner.model.view.SupplierProfileViewModel;
import bg.softuni.weedinfplanner.service.*;
import bg.softuni.weedinfplanner.service.impl.WPUserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class SupplierController {

    private final SupplierService supplierService;
    private final CityService cityService;
    private final RegionService regionService;
    private final ModelMapper modelMapper;
    private final OfferService offerService;

    public SupplierController(SupplierService supplierService, CityService cityService, RegionService regionService, ModelMapper modelMapper, OfferService offerService) {
        this.supplierService = supplierService;
        this.cityService = cityService;
        this.regionService = regionService;
        this.modelMapper = modelMapper;
        this.offerService = offerService;
    }

    // REGISTER SUPPLIER
    @ModelAttribute
    public SupplierRegisterBindingModel supplierRegisterBindingModel() {
        return new SupplierRegisterBindingModel();
    }

    @GetMapping("/register/supplier")
    public String registerSupplier(Model model) {
        model.addAttribute("cities", this.cityService.getAllCities());
        model.addAttribute("regions", this.regionService.getAllRegions());
        model.addAttribute("categories", CategorySupplierEnum.values());
        return "register-supplier";
    }

    @PostMapping("/register/supplier")
    public String registerSupplier(@Valid @ModelAttribute("supplierRegisterBindingModel") SupplierRegisterBindingModel supplierRegisterBindingModel,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("supplierRegisterBindingModel", supplierRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.supplierRegisterBindingModel", bindingResult);
            return "redirect:/register/supplier";
        }

        SupplierRegisterServiceModel supplierRegisterServiceModel = this.modelMapper.map(supplierRegisterBindingModel, SupplierRegisterServiceModel.class);
        this.supplierService.save(supplierRegisterServiceModel);
        return "redirect:/";
    }

    //MY PROFILE PAGE
    @ModelAttribute
    public SupplierProfileUpdateBindingModel supplierProfileUpdateBindingModel() {
        return new SupplierProfileUpdateBindingModel();
    }

    @GetMapping("/supplier-profile")
    public String profile (Model model, Principal principal) {
        if(!model.containsAttribute("hasErrors")) {
            model.addAttribute("hasErrors",false);
        }
        //add binding supplierProfileUpdateBindingModel on get request so we can fill form inputs with needed values
        SupplierProfileViewModel supplierProfileViewModel
                = this.supplierService.getSupplierProfileViewModelByEmail(principal.getName());
        SupplierProfileUpdateBindingModel supplierProfileUpdateBindingModel
                = this.modelMapper.map(supplierProfileViewModel, SupplierProfileUpdateBindingModel.class);
        supplierProfileUpdateBindingModel.setCityName(supplierProfileViewModel.getAddress().getCityName());
        // add attributes
        model.addAttribute("cities", this.cityService.getAllCities());
        model.addAttribute("supplierProfileUpdateBindingModel",supplierProfileUpdateBindingModel);
        model.addAttribute("supplierProfileViewModel",supplierProfileViewModel);
        return "supplier-profile";
    }

    @GetMapping("/supplier-profile/errors")
    public String profileErrors (Model model,Principal principal) {
        SupplierProfileViewModel supplierProfileViewModel
                = this.supplierService.getSupplierProfileViewModelByEmail(principal.getName());
        model.addAttribute("cities", this.cityService.getAllCities());
        model.addAttribute("supplierProfileViewModel",supplierProfileViewModel);
        return "supplier-profile";
    }


    @PatchMapping("/supplier-profile")
    public String profileUpdate(@Valid SupplierProfileUpdateBindingModel supplierProfileUpdateBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("hasErrors",true);
            redirectAttributes.addFlashAttribute("supplierProfileUpdateBindingModel", supplierProfileUpdateBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.supplierProfileUpdateBindingModel", bindingResult);
            return "redirect:/supplier-profile/errors";
        }

        this.supplierService.updateSupplierProfile(supplierProfileUpdateBindingModel,principal);

        return "redirect:/supplier-profile";
    }

    //MY OFFERS
    @GetMapping("/supplier-profile/my-offers")
    public String myOffers (Model model, Principal principal) {
        List<OffersAllViewModel> supplierOffers
                =this.offerService.getCurrentUserOffers(principal);
        model.addAttribute("currentUserCompanyName",this.supplierService.getCurrentUserCompanyName(principal));
        model.addAttribute("supplierOffers",supplierOffers);
        return "my-offers";
    }
}
