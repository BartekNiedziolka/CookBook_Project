package pl.coderslab.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.model.Recipe;
import pl.coderslab.repository.RecipeRepository;

public class RecipeConvereter implements Converter<String, Recipe> {
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Recipe convert(String s) {
        return recipeRepository.findOne(Long.parseLong(s));
    }
}
