package bg.softuni.weedinfplanner.web;

import bg.softuni.weedinfplanner.model.binding.GuestAddBindingModel;
import bg.softuni.weedinfplanner.model.binding.GuestUpdateBindingModel;
import bg.softuni.weedinfplanner.model.binding.PartnerNamesAddBindingModel;
import bg.softuni.weedinfplanner.model.entity.enums.AgeEnum;
import bg.softuni.weedinfplanner.model.entity.enums.AttendEnum;
import bg.softuni.weedinfplanner.model.entity.enums.TypeGuestEnum;
import bg.softuni.weedinfplanner.model.service.BrideAndGroomNamesServiceModel;
import bg.softuni.weedinfplanner.model.service.GuestAddServiceModel;
import bg.softuni.weedinfplanner.model.service.GuestUpdateServiceModel;
import bg.softuni.weedinfplanner.model.service.PartnerNamesAddServiceModel;
import bg.softuni.weedinfplanner.model.view.BrideAndGroomNamesViewModel;
import bg.softuni.weedinfplanner.model.view.GuestViewModel;
import bg.softuni.weedinfplanner.service.GuestService;
import bg.softuni.weedinfplanner.service.UserService;
import bg.softuni.weedinfplanner.service.WeddingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WeddingGuestsController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final GuestService guestService;
    private final WeddingService weddingService;

    public WeddingGuestsController(UserService userService, ModelMapper modelMapper, GuestService guestService, WeddingService weddingService) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.guestService = guestService;
        this.weddingService = weddingService;
    }

    //WEDDING GUESTS PAGE
    @GetMapping("/wedding-guests")
    public String weddingGuests(Model model, Principal principal, HttpServletRequest request) {
        BrideAndGroomNamesServiceModel brideAndGroom
                = this.userService.findBrideAndGroomNamesViewModel(principal);

        List<GuestViewModel> allGuests = this.guestService.getAllGuests(principal)
                .stream()
                .map(guestAddServiceModel -> this.modelMapper.map(guestAddServiceModel, GuestViewModel.class))
                .collect(Collectors.toList());
        Long allAttending
                = this.guestService.findCountOfGuestsByAttendanceForCurrentUser(principal, AttendEnum.ATTENDING);
        Long allDeclined
                = this.guestService.findCountOfGuestsByAttendanceForCurrentUser(principal, AttendEnum.DECLINED);
        Long allPending
                = this.guestService.findCountOfGuestsByAttendanceForCurrentUser(principal, AttendEnum.PENDING);
        model.addAttribute("brideAndGroomInfo", this.modelMapper.map(brideAndGroom, BrideAndGroomNamesViewModel.class));
        model.addAttribute("types", TypeGuestEnum.values());
        model.addAttribute("attendSt", AttendEnum.values());
        model.addAttribute("ageRanges", AgeEnum.values());
        model.addAttribute("allGuests", allGuests);
        model.addAttribute("allAttending",allAttending);
        model.addAttribute("allDeclined",allDeclined);
        model.addAttribute("allPending",allPending);
        return "wedding-guests";
    }

    //ADD PARTNER`S INFO
    @ModelAttribute
    public PartnerNamesAddBindingModel partnerNamesAddBindingModel() {
        return new PartnerNamesAddBindingModel();
    }

    @PatchMapping("/wedding-guests/add-partner")
    public String addPartner(@Valid PartnerNamesAddBindingModel partnerNamesAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("hasErrors", true);
            redirectAttributes.addFlashAttribute("partnerNamesAddBindingModel", partnerNamesAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.partnerNamesAddBindingModel", bindingResult);
            return "redirect:/wedding-guests";
        }

        this.userService.savePartnerNames
                (this.modelMapper.map(partnerNamesAddBindingModel, PartnerNamesAddServiceModel.class), principal);

        return "redirect:/wedding-guests";
    }

    //ADD NEW GUEST
    @ModelAttribute
    public GuestAddBindingModel guestAddBindingModel() {
        return new GuestAddBindingModel();
    }

    @PostMapping("/wedding-guests")
    public String addGuest(@Valid GuestAddBindingModel guestAddBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           Principal principal) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("hasErrorsAddGuest", true);
            redirectAttributes.addFlashAttribute("guestAddBindingModel", guestAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.guestAddBindingModel", bindingResult);
            return "redirect:/wedding-guests";
        }

        GuestAddServiceModel guestAddServiceModel
                = this.modelMapper.map(guestAddBindingModel, GuestAddServiceModel.class);

        this.guestService.saveGuest(guestAddServiceModel, principal);

        return "redirect:/wedding-guests";
    }

    //UPDATE GUEST
    @ModelAttribute
    public GuestUpdateBindingModel guestUpdateBindingModel() {
        return new GuestUpdateBindingModel();
    }

    @GetMapping("/wedding-guests/{id}")
    public String weddingGuests(@PathVariable Long id, Model model, Principal principal) {
        GuestUpdateServiceModel guestUpdateServiceModel = this.guestService.getGuestUpdateServiceModelById(id);

        model.addAttribute("guest",this.modelMapper.map(guestUpdateServiceModel,GuestViewModel.class));
        model.addAttribute("guestUpdateBindingModel",this.modelMapper.map(guestUpdateServiceModel,GuestUpdateBindingModel.class));
        model.addAttribute("types", TypeGuestEnum.values());
        model.addAttribute("attendSt", AttendEnum.values());
        model.addAttribute("ageRanges", AgeEnum.values());

        return "guest-update";
    }


    @GetMapping("/wedding-guests/{id}/errors")
    public String errorsUpdateGuest(@PathVariable Long id, Model model) {
        GuestUpdateServiceModel guestUpdateServiceModel = this.guestService.getGuestUpdateServiceModelById(id);
        model.addAttribute("guest",this.modelMapper.map(guestUpdateServiceModel,GuestViewModel.class));
        model.addAttribute("types", TypeGuestEnum.values());
        model.addAttribute("attendSt", AttendEnum.values());
        model.addAttribute("ageRanges", AgeEnum.values());
        return "guest-update";
    }

    @PatchMapping("/wedding-guests/{id}")
    public String updateGuest( @PathVariable Long id,
            @Valid GuestUpdateBindingModel guestUpdateBindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("hasErrorsUpdateGuest", true);
            redirectAttributes.addFlashAttribute("guestUpdateBindingModel", guestUpdateBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.guestUpdateBindingModel", bindingResult);
            return "redirect:/wedding-guests/{id}/errors";
        }
        GuestUpdateServiceModel guestUpdateServiceModel = this.modelMapper.map(guestUpdateBindingModel, GuestUpdateServiceModel.class);
        this.guestService.updateGuest(id,guestUpdateServiceModel,principal);

        return "redirect:/wedding-guests";
    }


    @DeleteMapping("/wedding-guests/{id}")
    public String deleteGuest (@PathVariable Long id) {
        this.guestService.deleteGuest(id);
        return "redirect:/wedding-guests";
    }


}
