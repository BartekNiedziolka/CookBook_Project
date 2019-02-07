package pl.niedziolka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.niedziolka.model.Recipe;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findAllByUserId(long userId);


}

