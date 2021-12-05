package bg.softuni.weedinfplanner.service;

import bg.softuni.weedinfplanner.model.entity.User;
import bg.softuni.weedinfplanner.model.service.*;
import bg.softuni.weedinfplanner.model.view.BrideAndGroomNamesViewModel;
import bg.softuni.weedinfplanner.model.view.UserProfileUpdateViewModel;

import java.security.Principal;
import java.util.List;

public interface UserService {

    void save(UserRegisterServiceModel userRegisterBindingModel);

    User findUserByEmail(String email);

    BrideAndGroomNamesServiceModel findBrideAndGroomNamesViewModel(Principal principal);

    void savePartnerNames(PartnerNamesAddServiceModel partnerNamesAddServiceModel,Principal principal);

    User getCurrentUser(Principal principal);

    UserProfileUpdateViewModel getUserProfileViewModelByEmail(String email);

    void updateUserProfile(UserProfileUpdateServiceModel userProfileUpdateServiceModel, Principal principal);

    List<UsersAllServiceModel> findAllUsers();

    boolean existByEmail(String email);

    void makeUserAdmin(String email);

    void removeAdminRole(String email);


}
