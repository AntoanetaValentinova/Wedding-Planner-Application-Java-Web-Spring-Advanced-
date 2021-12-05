package bg.softuni.weedinfplanner.web;

import bg.softuni.weedinfplanner.model.view.OffersAllViewModel;
import bg.softuni.weedinfplanner.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HomeRestController {
    private final OfferService offerService;
    private final ModelMapper modelMapper;

    public HomeRestController(OfferService offerService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/api/venues")
    public ResponseEntity<List<OffersAllViewModel>> getVenues() {
        List<OffersAllViewModel> venues = this.offerService.getAllApprovedOffersByCategory("VENUES")
                .stream()
                .map(offersAllServiceModel -> this.modelMapper.map(offersAllServiceModel, OffersAllViewModel.class))
                .limit(5L)
                .collect(Collectors.toList());

        return ResponseEntity.ok(venues);
    }

    @GetMapping("/api/photographers")
    public ResponseEntity<List<OffersAllViewModel>> getPhotographers() {
        List<OffersAllViewModel> photographers = this.offerService.getAllApprovedOffersByCategory("PHOTOGRAPHERS")
                .stream()
                .map(offersAllServiceModel -> this.modelMapper.map(offersAllServiceModel, OffersAllViewModel.class))
                .limit(5L)
                .collect(Collectors.toList());

        return ResponseEntity.ok(photographers);
    }

    @GetMapping("/api/music")
    public ResponseEntity<List<OffersAllViewModel>> getMusic() {
        List<OffersAllViewModel> music = this.offerService.getAllApprovedOffersByCategory("MUSIC")
                .stream()
                .map(offersAllServiceModel -> this.modelMapper.map(offersAllServiceModel, OffersAllViewModel.class))
                .limit(5L)
                .collect(Collectors.toList());

        return ResponseEntity.ok(music);
    }
}
