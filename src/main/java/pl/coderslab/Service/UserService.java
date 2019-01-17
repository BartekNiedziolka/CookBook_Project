package pl.coderslab.Service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;


@Component
@Transactional
public class UserService {


    @Autowired
    UserRepository userRepository;


    public boolean checkIfUserExists(User user){
        if(userRepository.findByEmail(user.getEmail()) != null || userRepository.findByUserName(user.getUserName()) != null){
            return true;
        }
        return false;
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
