package bg.softuni.weedinfplanner.repository;

import bg.softuni.weedinfplanner.model.entity.Offer;
import bg.softuni.weedinfplanner.model.entity.Wedding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface WeddingRepository extends JpaRepository<Wedding, Long> {

    Optional<Wedding> findWeddingByUserEmail(String email);

    @Query("SELECT w.favouriteOffers FROM Wedding as w WHERE w.user.email=:email")
    List<Offer> findFavouriteOffers(String email);


    @Query("SELECT w.reservedOffers FROM Wedding as w WHERE w.user.email=:email")
    List<Offer> findHiredReservedOffers(String email);

}
