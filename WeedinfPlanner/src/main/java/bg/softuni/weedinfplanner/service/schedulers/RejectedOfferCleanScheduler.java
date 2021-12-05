package bg.softuni.weedinfplanner.service.schedulers;

import bg.softuni.weedinfplanner.model.entity.Offer;
import bg.softuni.weedinfplanner.service.OfferService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class RejectedOfferCleanScheduler {

    private final OfferService offerService;

    public RejectedOfferCleanScheduler(OfferService offerService) {
        this.offerService = offerService;
    }

    @Scheduled(cron = "00 30 00 * * *")
    public void cleanRejectedOffersNotUpdated30Days() {
        this.offerService.getAllRejectedOffers()
                .forEach(offer -> {
                    LocalDate created = offer.getCreated();
                    LocalDate expiredDate = created.plusMonths(1L);
                    if (expiredDate.equals(LocalDate.now())) {
                        this.offerService.deleteOffer(offer.getId());
                    }
                });
    }
}
