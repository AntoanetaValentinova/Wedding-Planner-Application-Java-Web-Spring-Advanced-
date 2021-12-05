package bg.softuni.weedinfplanner.service;

import bg.softuni.weedinfplanner.model.entity.CategorySupplier;
import bg.softuni.weedinfplanner.model.entity.enums.CategorySupplierEnum;

public interface CategorySupplierService {


    CategorySupplier findCategorySupplierByName(CategorySupplierEnum categorySupplierEnum);
}
