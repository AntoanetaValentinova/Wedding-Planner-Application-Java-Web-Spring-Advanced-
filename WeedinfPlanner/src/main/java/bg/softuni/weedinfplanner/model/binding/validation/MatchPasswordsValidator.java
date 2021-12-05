package bg.softuni.weedinfplanner.model.binding.validation;

import bg.softuni.weedinfplanner.model.binding.SupplierRegisterBindingModel;
import bg.softuni.weedinfplanner.model.binding.UserRegisterBindingModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MatchPasswordsValidator implements ConstraintValidator<MatchPasswords, Object> {

    private String message;

    @Override
    public void initialize(MatchPasswords matchPasswords) {
        this.message = matchPasswords.message();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        boolean isValid = false;
        if (obj.getClass().equals(UserRegisterBindingModel.class)) {
            UserRegisterBindingModel userDto = (UserRegisterBindingModel) obj;
            isValid = userDto.getPassword().equals(userDto.getConfirmPassword());
        } else if (obj.getClass().equals(SupplierRegisterBindingModel.class)) {
            SupplierRegisterBindingModel supplierDto = (SupplierRegisterBindingModel) obj;
            isValid = supplierDto.getPassword().equals(supplierDto.getConfirmPassword());
        }
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("confirmPassword").addConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("password").addConstraintViolation();
        }
        return isValid;
    }
}
