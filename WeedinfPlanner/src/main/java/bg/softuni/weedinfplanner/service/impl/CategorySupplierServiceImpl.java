package bg.softuni.weedinfplanner.service.impl;

import bg.softuni.weedinfplanner.model.entity.CategorySupplier;
import bg.softuni.weedinfplanner.model.entity.enums.CategorySupplierEnum;
import bg.softuni.weedinfplanner.repository.CategorySupplierRepository;
import bg.softuni.weedinfplanner.service.CategorySupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategorySupplierServiceImpl implements CategorySupplierService {

    private final CategorySupplierRepository categorySupplierRepository;
    private final ModelMapper modelMapper;

    public CategorySupplierServiceImpl(CategorySupplierRepository categorySupplierRepository, ModelMapper modelMapper) {
        this.categorySupplierRepository = categorySupplierRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public CategorySupplier findCategorySupplierByName(CategorySupplierEnum categorySupplierEnum) {
        return this.categorySupplierRepository.findCategorySupplierByName(categorySupplierEnum);
    }
}
