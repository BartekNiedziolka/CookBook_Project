package pl.niedziolka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.niedziolka.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUserName(String userName);
    //User findByRecipe
}

