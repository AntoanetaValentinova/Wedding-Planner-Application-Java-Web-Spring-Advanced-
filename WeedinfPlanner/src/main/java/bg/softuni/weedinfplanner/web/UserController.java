package bg.softuni.weedinfplanner.web;

import bg.softuni.weedinfplanner.model.binding.UserProfileUpdateBindingModel;
import bg.softuni.weedinfplanner.model.binding.UserRegisterBindingModel;
import bg.softuni.weedinfplanner.model.service.UserProfileUpdateServiceModel;
import bg.softuni.weedinfplanner.model.service.UserRegisterServiceModel;
import bg.softuni.weedinfplanner.model.view.UserProfileUpdateViewModel;
import bg.softuni.weedinfplanner.service.SupplierService;
import bg.softuni.weedinfplanner.service.UserService;
import bg.softuni.weedinfplanner.service.impl.WPUserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
import java.time.LocalDate;

@Controller
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    //REGISTER USER
    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel () {
        return new UserRegisterBindingModel();
    }

    @GetMapping("/register/user")
    public String registerUser() {
        return "register-user";
    }

    @PostMapping("/register/user")
    public String registerUserPost(@Valid UserRegisterBindingModel userRegisterBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:/register/user";
        }

        UserRegisterServiceModel userRegisterServiceModel = this.modelMapper.map(userRegisterBindingModel, UserRegisterServiceModel.class);
        this.userService.save(userRegisterServiceModel);

        return "redirect:/";
    }

    //MY PROFILE PAGE
    @ModelAttribute
    public UserProfileUpdateBindingModel userProfileUpdateBindingModel() {
        return new UserProfileUpdateBindingModel();
    }

    @GetMapping("/user-profile")
    public String profile (Model model, Principal principal) {
        if(!model.containsAttribute("hasErrors")) {
            model.addAttribute("hasErrors",false);
        }
        //add binding userProfileUpdateBindingModel on get request so we can fill form inputs with needed values
        UserProfileUpdateViewModel userProfileUpdateViewModel
                = this.userService.getUserProfileViewModelByEmail(principal.getName());
        UserProfileUpdateBindingModel userProfileUpdateBindingModel
                = this.modelMapper.map(userProfileUpdateViewModel, UserProfileUpdateBindingModel.class);
        // add attributes
        model.addAttribute("user",userProfileUpdateViewModel);
        model.addAttribute("userProfileUpdateBindingModel",userProfileUpdateBindingModel);
        return "user-profile";
    }

    @GetMapping("/user-profile/errors")
    public String profileErrors (Model model,Principal principal) {
        UserProfileUpdateViewModel userProfileUpdateViewModel
                = this.userService.getUserProfileViewModelByEmail(principal.getName());
        model.addAttribute("user",userProfileUpdateViewModel);
        return "user-profile";
    }

    @PatchMapping("/user-profile")
    public String profileUpdate(@Valid UserProfileUpdateBindingModel userProfileUpdateBindingModel,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("hasErrors",true);
            redirectAttributes.addFlashAttribute("userProfileUpdateBindingModel", userProfileUpdateBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userProfileUpdateBindingModel", bindingResult);
            return "redirect:/user-profile/errors";
        }

        UserProfileUpdateServiceModel userProfileUpdateServiceModel
                = this.modelMapper.map(userProfileUpdateBindingModel, UserProfileUpdateServiceModel.class);
        this.userService.updateUserProfile(userProfileUpdateServiceModel,principal);

        return "redirect:/user-profile";
    }


}
