package bg.softuni.weedinfplanner.service.impl;

import bg.softuni.weedinfplanner.model.entity.Offer;
import bg.softuni.weedinfplanner.model.entity.StatusEnum;
import bg.softuni.weedinfplanner.model.entity.enums.CategorySupplierEnum;
import bg.softuni.weedinfplanner.model.service.OfferAddServiceModel;
import bg.softuni.weedinfplanner.model.service.OfferUpdateServiceModel;
import bg.softuni.weedinfplanner.model.service.OffersAllServiceModel;
import bg.softuni.weedinfplanner.model.service.PictureAddServiceModel;
import bg.softuni.weedinfplanner.model.view.OfferDetailsViewModel;
import bg.softuni.weedinfplanner.model.view.OffersAllViewModel;
import bg.softuni.weedinfplanner.repository.OfferRepository;
import bg.softuni.weedinfplanner.service.*;
import bg.softuni.weedinfplanner.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final SupplierService supplierService;
    private final CategorySupplierService categorySupplierService;
    private final CloudinaryService cloudinaryService;
    private final PictureService pictureService;
    private final WeddingService weddingService;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, SupplierService supplierService, CategorySupplierService categorySupplierService, CloudinaryService cloudinaryService, PictureService pictureService,@Lazy WeddingService weddingService) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.supplierService = supplierService;
        this.categorySupplierService = categorySupplierService;
        this.cloudinaryService = cloudinaryService;
        this.pictureService = pictureService;
        this.weddingService = weddingService;
    }

    @Override
    public List<OffersAllViewModel> getAllOffers() {
        return this.offerRepository.findAll()
                .stream()
                .map(offer -> this.modelMapper.map(offer, OffersAllViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public OfferDetailsViewModel findOfferViewModelById(Long id) {
        Offer offer = this.offerRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());

        OfferDetailsViewModel offerDetailsViewModel
                = this.modelMapper.map(offer, OfferDetailsViewModel.class);
        offerDetailsViewModel.setSupplier(offer.getSupplier().getEmail());
        offerDetailsViewModel.setAddress(offer.getSupplier().getAddress().getAddress());
        offerDetailsViewModel.setCity(offer.getSupplier().getAddress().getCity().getName());
        offerDetailsViewModel.setRegion(offer.getSupplier().getAddress().getCity().getRegion().getName());

        return offerDetailsViewModel;
    }

    @Override
    public List<OffersAllViewModel> getCurrentUserOffers(Principal principal) {
        List<OffersAllViewModel> collect = this.offerRepository.findAllBySupplier_Email(principal.getName())
                .stream()
                .map(offer -> {
                    OffersAllViewModel offersAllViewModel = this.modelMapper.map(offer, OffersAllViewModel.class);
                    offersAllViewModel.setCategory(offer.getCategory().getName());
                    return offersAllViewModel;
                })
                .collect(Collectors.toList());

        return collect;
    }

    @Override
    public Offer getOfferById(Long id) {
        return this.offerRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());
    }

    @Override
    public boolean isCurrentUserOwner(Principal principal, Long id) {
        Offer offer = this.offerRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());
        if(principal!=null && principal.getName().equals(offer.getSupplier().getEmail())) {
            return true;
        }
        return false;
    }

    @Override
    public Long addNewOffer(OfferAddServiceModel offerAddServiceModel, Principal principal) {
        //map offer service to offer entity
        Offer offerToAdd = this.modelMapper.map(offerAddServiceModel, Offer.class);
        offerToAdd.setCategory(this.categorySupplierService.findCategorySupplierByName(offerAddServiceModel.getCategory()));
        offerToAdd.setSupplier(this.supplierService.findSupplierByEmail(principal.getName()));
        offerToAdd.setStatus(StatusEnum.PENDING);
        Offer savedOffer = this.offerRepository.save(offerToAdd);
        savedOffer.getPictures().clear();

        //save pictures to Cloudinary,save them in repo and add in offer
        offerAddServiceModel.getPicturesBind()
                .stream()
                .forEach(pictureAddServiceModel -> {
                    try {
                        this.pictureService.getPictureEntity(savedOffer, pictureAddServiceModel);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        Offer savedOfferWithPictures = this.offerRepository.save(savedOffer);

        return savedOfferWithPictures.getId();
    }

    @Override
    public void updateOffer(OfferUpdateServiceModel offerUpdateServiceModel, Long id) {
        Offer offer = this.offerRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());;
        offer.setAbout(offerUpdateServiceModel.getAbout());
        offer.setDescription(offerUpdateServiceModel.getDescription());
        offer.setKmCoverageFromAddress(offerUpdateServiceModel.getKmCoverageFromAddress());
        offer.setMaxPrice(offerUpdateServiceModel.getMaxPrice());
        offer.setMinPrice(offerUpdateServiceModel.getMinPrice());
        offer.setPhoneNumber(offerUpdateServiceModel.getPhoneNumber());
        offer.setTitle(offerUpdateServiceModel.getTitle());
        offer.setStatus(StatusEnum.PENDING);
        this.offerRepository.save(offer);
    }

    @Override
    public void deleteOffer(Long id) {
        Offer offer = this.offerRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());
        removeAssociations(offer);
        deletePicturesFromCloud(offer);
        this.offerRepository.deleteById(id);
    }

    private void deletePicturesFromCloud(Offer offer) {
        offer.getPictures()
                .forEach(picture -> this.cloudinaryService.delete(picture.getPublicId()));
    }

    private void removeAssociations(Offer offer) {
        //remove the association with weddings who add current offer to their reserved offer set
        offer.getWeddingsReserved().forEach(wedding -> {
                    wedding.getReservedOffers().remove(offer);
                    this.weddingService.save(wedding);
                });
        //remove the association with weddings who add current offer to their favourite offer set
        offer.getWeddingsFavourites().forEach(wedding -> {
            wedding.getFavouriteOffers().remove(offer);
            this.weddingService.save(wedding);
        });
    }

    @Override
    public void addNewPicture(PictureAddServiceModel pictureAddServiceModel, Long offerId) throws IOException {
        Offer offer = this.offerRepository.findById(offerId).orElseThrow(() -> new ObjectNotFoundException());
        this.pictureService.getPictureEntity(offer,pictureAddServiceModel);
    }

    @Override
    public void deletePicture(Long picId) {
        this.pictureService.deletePicture(picId);
    }

    @Override
    public List<OffersAllServiceModel> getAllApprovedOffersServiceModel() {
        return this.offerRepository.findAllByStatus(StatusEnum.APPROVED)
                .stream().map(offer -> this.modelMapper.map(offer,OffersAllServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OffersAllServiceModel> getAllPendingOffersServiceModel() {

        return this.offerRepository.findAllByStatus(StatusEnum.PENDING)
                .stream()
                .map(offer -> this.modelMapper.map(offer,OffersAllServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void approveOffer(Long id) {
        Offer offer = this.offerRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());
        offer.setStatus(StatusEnum.APPROVED);
        this.offerRepository.save(offer);
    }

    @Override
    public void rejectOffer(Long id) {
        Offer offer = this.offerRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException());
        offer.setStatus(StatusEnum.DECLINED);
        this.offerRepository.save(offer);
    }

    @Override
    public List<OffersAllServiceModel> getAllApprovedOffersByCategory(String category) {
        return  this.offerRepository.findAllByCategoryNameAndStatus(CategorySupplierEnum.valueOf(category.toUpperCase()),StatusEnum.APPROVED)
                .stream()
                .map(offer -> this.modelMapper.map(offer,OffersAllServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Offer> getAllRejectedOffers() {
        return this.offerRepository.findAllByStatus(StatusEnum.DECLINED);
    }


}
