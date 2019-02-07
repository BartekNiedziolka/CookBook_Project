package pl.niedziolka.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.niedziolka.model.Recipe;
import pl.niedziolka.repository.RecipeRepository;

public class RecipeConvereter implements Converter<String, Recipe> {
    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Recipe convert(String s) {
        return recipeRepository.findOne(Long.parseLong(s));
    }
}
