package bg.softuni.weedinfplanner.repository;

import bg.softuni.weedinfplanner.model.entity.CategorySupplier;
import bg.softuni.weedinfplanner.model.entity.enums.CategorySupplierEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategorySupplierRepository extends JpaRepository<CategorySupplier, Long> {


    List<CategorySupplier> findAllBy();

    CategorySupplier findCategorySupplierByName(CategorySupplierEnum category);
}
