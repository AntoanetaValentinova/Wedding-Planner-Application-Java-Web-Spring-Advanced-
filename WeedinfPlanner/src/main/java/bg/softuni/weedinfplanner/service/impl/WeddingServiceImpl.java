package bg.softuni.weedinfplanner.service.impl;

import bg.softuni.weedinfplanner.model.entity.Guest;
import bg.softuni.weedinfplanner.model.entity.Offer;
import bg.softuni.weedinfplanner.model.entity.User;
import bg.softuni.weedinfplanner.model.entity.Wedding;
import bg.softuni.weedinfplanner.model.service.OffersAllServiceModel;
import bg.softuni.weedinfplanner.model.service.WeddingDateServiceModel;
import bg.softuni.weedinfplanner.repository.WeddingRepository;
import bg.softuni.weedinfplanner.service.OfferService;
import bg.softuni.weedinfplanner.service.WeddingService;
import bg.softuni.weedinfplanner.service.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeddingServiceImpl implements WeddingService {

    private final WeddingRepository weddingRepository;
    private final ModelMapper modelMapper;
    private final OfferService offerService;


    public WeddingServiceImpl(WeddingRepository weddingRepository, ModelMapper modelMapper, OfferService offerService) {
        this.weddingRepository = weddingRepository;
        this.modelMapper = modelMapper;
        this.offerService = offerService;
    }

    @Override
    public Wedding save(Wedding wedding) {
        return this.weddingRepository.save(wedding);
    }

    @Override
    public void addGuest(Guest guest, User currentUser) {
        currentUser.getWedding().getGuests().add(guest);
    }

    @Override
    public Wedding getWeddingByUserEmail(String email) {
        return this.weddingRepository.findWeddingByUserEmail(email).orElseThrow(() -> new ObjectNotFoundException());
    }

    @Override
    public LocalDate getWeddingDateForCurrentUser(Principal principal) {
        return this.weddingRepository.findWeddingByUserEmail(principal.getName())
                .orElseThrow(() -> new ObjectNotFoundException())
                .getDate();
    }

    @Override
    public void addToFavourite(Long offerId, Principal principal) {
        Wedding wedding
                = this.weddingRepository.findWeddingByUserEmail(principal.getName()).orElseThrow(() -> new ObjectNotFoundException());
        Offer offer = this.offerService.getOfferById(offerId);
        wedding.getFavouriteOffers().add(offer);
        this.weddingRepository.save(wedding);
    }

    @Override
    public void addToHired(Long offerId, Principal principal) {
        Wedding wedding
                = this.weddingRepository.findWeddingByUserEmail(principal.getName()).orElseThrow(() -> new ObjectNotFoundException());
        Offer offer = this.offerService.getOfferById(offerId);
        wedding.getReservedOffers().add(offer);
        this.weddingRepository.save(wedding);
    }

    @Override
    public List<OffersAllServiceModel> getAllFavouriteOffers(Principal principal) {
        return this.weddingRepository.findFavouriteOffers(principal.getName())
                .stream()
                .map(offer -> this.modelMapper.map(offer,OffersAllServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addWeddingDate(WeddingDateServiceModel weddingDateServiceModel, Principal principal) {
        Wedding wedding = this.weddingRepository.findWeddingByUserEmail(principal.getName()).orElseThrow(() -> new ObjectNotFoundException());
        wedding.setDate(weddingDateServiceModel.getDate());
        this.weddingRepository.save(wedding);
    }

    @Override
    public List<OffersAllServiceModel> getAllHired(Principal principal) {
        return this.weddingRepository.findHiredReservedOffers(principal.getName())
                .stream()
                .map(offer -> this.modelMapper.map(offer,OffersAllServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean findIfOfferIsInFavouriteList(Long id, Principal principal) {
        Offer offerById = offerService.getOfferById(id);
        List<Offer> collect = this.weddingRepository.findFavouriteOffers(principal.getName())
                .stream()
                .filter(offer -> offer.getId().equals(id))
                .collect(Collectors.toList());
        if(collect.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public void removeFromFavourite(Long offerId, Principal principal) {
        Wedding wedding
                = this.weddingRepository.findWeddingByUserEmail(principal.getName()).orElseThrow(() -> new ObjectNotFoundException());
        wedding.getFavouriteOffers().removeIf(offer -> offer.getId().equals(offerId));
        this.weddingRepository.save(wedding);
    }

    @Override
    public boolean findIfOfferIsInHiredList(Long id, Principal principal) {
        Offer offerById = offerService.getOfferById(id);
        List<Offer> collect = this.weddingRepository.findHiredReservedOffers(principal.getName())
                .stream()
                .filter(offer -> offer.getId().equals(id))
                .collect(Collectors.toList());
        if(collect.isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public void removeFromHired(Long offerId, Principal principal) {
        Wedding wedding
                = this.weddingRepository.findWeddingByUserEmail(principal.getName()).orElseThrow(() -> new ObjectNotFoundException());
        wedding.getReservedOffers().removeIf(offer -> offer.getId().equals(offerId));
        this.weddingRepository.save(wedding);
    }
}
