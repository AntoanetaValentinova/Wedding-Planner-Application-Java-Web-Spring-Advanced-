package bg.softuni.weedinfplanner.repository;

import bg.softuni.weedinfplanner.model.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    Optional<Supplier> findSupplierByEmail(String email);

    boolean existsByEmail(String email);

}
