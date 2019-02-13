package pl.niedziolka.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    //must contains one lowercase and one uppercase characters, and length between 6 and 20
    private static final String PASSWORD_PATTERN = "(?=.*[a-z])(?=.*[A-Z]).{6,20}";

    @Override
    public void initialize(Password password) {

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return password.matches(PASSWORD_PATTERN);
    }
}
