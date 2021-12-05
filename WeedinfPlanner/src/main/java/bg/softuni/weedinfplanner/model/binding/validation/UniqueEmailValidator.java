package bg.softuni.weedinfplanner.model.binding.validation;

import bg.softuni.weedinfplanner.repository.SupplierRepository;
import bg.softuni.weedinfplanner.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private UserRepository userRepository;
    private SupplierRepository supplierRepository;

    public UniqueEmailValidator(UserRepository userRepository, SupplierRepository supplierRepository) {
        this.userRepository = userRepository;
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {

        return this.userRepository.findUserByEmail(email).orElse(null) == null && this.supplierRepository.findSupplierByEmail(email).orElse(null) == null;
    }
}
