package bg.softuni.weedinfplanner.service.impl;
import bg.softuni.weedinfplanner.model.entity.Guest;
import bg.softuni.weedinfplanner.model.entity.User;
import bg.softuni.weedinfplanner.model.entity.enums.AttendEnum;
import bg.softuni.weedinfplanner.model.service.GuestAddServiceModel;
import bg.softuni.weedinfplanner.model.service.GuestUpdateServiceModel;
import bg.softuni.weedinfplanner.repository.GuestRepository;
import bg.softuni.weedinfplanner.service.GuestService;
import bg.softuni.weedinfplanner.service.UserService;
import bg.softuni.weedinfplanner.service.WeddingService;
import bg.softuni.weedinfplanner.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestServiceImpl implements GuestService {
    private final GuestRepository guestRepository;
    private final ModelMapper modelMapper;
    private final WeddingService weddingService;
    private final UserService userService;

    public GuestServiceImpl(GuestRepository guestRepository, ModelMapper modelMapper, WeddingService weddingService, UserService userService) {
        this.guestRepository = guestRepository;
        this.modelMapper = modelMapper;
        this.weddingService = weddingService;
        this.userService = userService;
    }

    @Override
    public void saveGuest(GuestAddServiceModel guestAddServiceModel, Principal principal) {
        User currentUser = this.userService.getCurrentUser(principal);
        Guest guest = this.modelMapper.map(guestAddServiceModel, Guest.class);
        guest.setWeddingToAttend(currentUser.getWedding());
        Guest savedGuest = this.guestRepository.save(guest);

        this.weddingService.addGuest(savedGuest,currentUser);
    }

    @Override
    public List<GuestAddServiceModel> getAllGuests(Principal principal) {
        return this.guestRepository.findAllByWeddingToAttend_User_Email(principal.getName())
                .stream()
                .map(guest -> this.modelMapper.map(guest, GuestAddServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public GuestUpdateServiceModel getGuestUpdateServiceModelById(Long id) {
        Guest guest = this.guestRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());
        return this.modelMapper.map(guest,GuestUpdateServiceModel.class);
    }

    @Override
    public void updateGuest(Long id, GuestUpdateServiceModel guestUpdateServiceModel,Principal principal) {
        Guest guest =this.guestRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());

        guest
                .setAttend(guestUpdateServiceModel.getAttend())
                .setEmail(guestUpdateServiceModel.getEmail())
                .setFirstName(guestUpdateServiceModel.getFirstName())
                .setLastName(guestUpdateServiceModel.getLastName())
                .setNeedHotel(guestUpdateServiceModel.isNeedHotel())
                .setPhoneNumber(guestUpdateServiceModel.getPhoneNumber())
                .setAge(guestUpdateServiceModel.getAge());
        this.guestRepository.save(guest);
    }

    @Override
    public void deleteGuest(Long id) {
        this.guestRepository.deleteById(id);
    }

    @Override
    public Long findCountOfGuestsByAttendanceForCurrentUser(Principal principal, AttendEnum attending) {
        return this.guestRepository.countAllByAttendAndWeddingToAttendUserEmail(attending, principal.getName());
    }

    @Override
    public Guest getGuestById(Long id) {
        Guest guest = this.guestRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());
        return guest;
    }


}
