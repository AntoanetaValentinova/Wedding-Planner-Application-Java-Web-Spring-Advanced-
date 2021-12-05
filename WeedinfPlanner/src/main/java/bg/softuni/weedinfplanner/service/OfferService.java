package bg.softuni.weedinfplanner.service;

import bg.softuni.weedinfplanner.model.entity.Offer;
import bg.softuni.weedinfplanner.model.service.OfferAddServiceModel;
import bg.softuni.weedinfplanner.model.service.OfferUpdateServiceModel;
import bg.softuni.weedinfplanner.model.service.OffersAllServiceModel;
import bg.softuni.weedinfplanner.model.service.PictureAddServiceModel;
import bg.softuni.weedinfplanner.model.view.OfferDetailsViewModel;
import bg.softuni.weedinfplanner.model.view.OffersAllViewModel;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

public interface OfferService {

    List<OffersAllViewModel> getAllOffers();

    OfferDetailsViewModel findOfferViewModelById(Long id);

    List<OffersAllViewModel> getCurrentUserOffers(Principal principal);

    Offer getOfferById(Long id);

    boolean isCurrentUserOwner(Principal principal, Long id);

    Long addNewOffer(OfferAddServiceModel offerAddServiceModel, Principal principal);

    void updateOffer(OfferUpdateServiceModel offerUpdateServiceModel, Long id);

    void deleteOffer(Long id);

    void addNewPicture(PictureAddServiceModel pictureAddServiceModel, Long offerId) throws IOException;

    void deletePicture(Long picId);

    List<OffersAllServiceModel> getAllApprovedOffersServiceModel();

    List<OffersAllServiceModel> getAllPendingOffersServiceModel();

    void approveOffer(Long id);

    void rejectOffer(Long id);

    List<OffersAllServiceModel> getAllApprovedOffersByCategory(String category);

    List<Offer> getAllRejectedOffers();
}
