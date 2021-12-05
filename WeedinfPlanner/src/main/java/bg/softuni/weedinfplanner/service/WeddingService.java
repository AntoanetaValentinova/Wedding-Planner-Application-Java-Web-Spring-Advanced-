package bg.softuni.weedinfplanner.service;

import bg.softuni.weedinfplanner.model.entity.Guest;
import bg.softuni.weedinfplanner.model.entity.User;
import bg.softuni.weedinfplanner.model.entity.Wedding;
import bg.softuni.weedinfplanner.model.service.OffersAllServiceModel;
import bg.softuni.weedinfplanner.model.service.WeddingDateServiceModel;
import bg.softuni.weedinfplanner.model.view.OffersAllViewModel;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface WeddingService {

    Wedding save(Wedding wedding);

    void addGuest(Guest guest, User currentUser);

    Wedding getWeddingByUserEmail(String email);

    LocalDate getWeddingDateForCurrentUser(Principal principal);

    void addToFavourite(Long offerId, Principal principal);

    void addToHired(Long offerId, Principal principal);

    List<OffersAllServiceModel> getAllFavouriteOffers(Principal principal);

    void addWeddingDate(WeddingDateServiceModel weddingDateServiceModel, Principal principal);

    List<OffersAllServiceModel> getAllHired(Principal principal);

    boolean findIfOfferIsInFavouriteList(Long id, Principal principal);

    void removeFromFavourite(Long offerId, Principal principal);

    boolean findIfOfferIsInHiredList(Long id, Principal principal);

    void removeFromHired(Long offerId, Principal principal);
}
