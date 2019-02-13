package pl.niedziolka.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.niedziolka.model.User;
import pl.niedziolka.repository.UserRepository;


@Component
@Transactional
public class UserService {


    @Autowired
    UserRepository userRepository;


    public boolean checkIfUserWithGivenEmailExists(User user){
        return userRepository.findByEmail(user.getEmail()) != null;
    }
    public boolean checkIfUserWithGivenLoginExists(User user){
        return userRepository.findByUserName(user.getUserName()) != null;
    }

    public boolean checkIfUserExists(User user){
        return checkIfUserWithGivenEmailExists(user) || checkIfUserWithGivenLoginExists(user);
    }

    public boolean successfulLogin(String login, String password){
        User user = userRepository.findByUserName(login);
        if (user != null) {
            if (BCrypt.checkpw(password, user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public void registerUser(User user) {
        String password = user.getPassword();
        user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        userRepository.save(user);
    }

}
