package bg.softuni.weedinfplanner.web;

import bg.softuni.weedinfplanner.model.binding.RegisterTypeUserDto;
import bg.softuni.weedinfplanner.model.binding.UserRegisterBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserSupplierController {

    //REGISTER USER OR SUPPLIER - STEP 1
    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterTypeUserDto typeUser) {
        if (typeUser.getUser().equals("user")) {
            return "redirect:/register/user";
        }
        return "redirect:/register/supplier";
    }

    //LOGIN USER OR SUPPLIER
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login-error")
    public String loginError(@ModelAttribute ("email") String email,
                             RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("badCredentials",true);
        redirectAttributes.addFlashAttribute("email",email);

        return "redirect:/login";
    }
}
