package pl.niedziolka.validator;

import org.springframework.beans.factory.annotation.Autowired;
import pl.niedziolka.model.User;
import pl.niedziolka.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.Max;
import java.util.List;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String>{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UniqueEmail uniqueEmail) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        try {
            List<String> emailsList = userRepository.queryFindAllEmails();
            return !emailsList.contains(email);

        } catch (NullPointerException e){

            return false;
        }
    }
}
