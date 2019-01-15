package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}

