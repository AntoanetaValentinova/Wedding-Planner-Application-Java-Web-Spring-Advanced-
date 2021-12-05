package bg.softuni.weedinfplanner.model.binding.validation;

import bg.softuni.weedinfplanner.model.binding.UserSupplierLoginBindingModel;
import bg.softuni.weedinfplanner.model.entity.Supplier;
import bg.softuni.weedinfplanner.model.entity.User;
import bg.softuni.weedinfplanner.repository.SupplierRepository;
import bg.softuni.weedinfplanner.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RegisteredValidator implements ConstraintValidator<Registered, Object> {
    private String message;

    private final UserRepository userRepository;
    private final SupplierRepository supplierRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisteredValidator(UserRepository userRepository, SupplierRepository supplierRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.supplierRepository = supplierRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void initialize(Registered registered) {
        this.message = registered.message();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {

        UserSupplierLoginBindingModel loginBindingModel = (UserSupplierLoginBindingModel) obj;
        User user = this.userRepository.findUserByEmail(loginBindingModel.getEmail()).orElse(null);
        Supplier supplierEntity = this.supplierRepository.findSupplierByEmail(loginBindingModel.getEmail()).orElse(null);

        boolean isValid = (user != null && this.passwordEncoder.matches(loginBindingModel.getPassword(), user.getPassword()))
                || (supplierEntity != null && this.passwordEncoder.matches(loginBindingModel.getPassword(), supplierEntity.getPassword()));

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("email").addConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("password").addConstraintViolation();
        }
        return isValid;
    }
}
