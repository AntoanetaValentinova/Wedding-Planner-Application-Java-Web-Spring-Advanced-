package bg.softuni.weedinfplanner.repository;

import bg.softuni.weedinfplanner.model.entity.Offer;
import bg.softuni.weedinfplanner.model.entity.StatusEnum;
import bg.softuni.weedinfplanner.model.entity.enums.CategorySupplierEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

        List<Offer> findAllByCategoryNameAndStatus(CategorySupplierEnum categoryName, StatusEnum status);

        List<Offer> findAllBySupplier_Email(String supplierEmail);

        List<Offer> findAllByStatus(StatusEnum status);

        Optional<Offer> findOfferByAbout(String about);



}
