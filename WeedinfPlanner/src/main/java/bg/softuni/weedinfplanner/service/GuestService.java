package bg.softuni.weedinfplanner.service;

import bg.softuni.weedinfplanner.model.binding.GuestUpdateBindingModel;
import bg.softuni.weedinfplanner.model.entity.Guest;
import bg.softuni.weedinfplanner.model.entity.enums.AttendEnum;
import bg.softuni.weedinfplanner.model.service.GuestAddServiceModel;
import bg.softuni.weedinfplanner.model.service.GuestUpdateServiceModel;

import java.security.Principal;
import java.util.List;

public interface GuestService {
    void saveGuest(GuestAddServiceModel guestAddServiceModel, Principal principal);

    List<GuestAddServiceModel> getAllGuests(Principal principal);

    GuestUpdateServiceModel getGuestUpdateServiceModelById(Long id);

    void updateGuest(Long id, GuestUpdateServiceModel guestUpdateServiceModel,Principal principal);

    void deleteGuest(Long id);

    Long findCountOfGuestsByAttendanceForCurrentUser(Principal principal, AttendEnum attending);

    Guest getGuestById(Long id);
}
