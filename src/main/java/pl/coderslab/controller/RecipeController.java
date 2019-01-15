package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.dto.RecipeDTO;
import pl.coderslab.model.QuantityComponent;
import pl.coderslab.model.Recipe;
import pl.coderslab.model.User;
import pl.coderslab.repository.RecipeRepository;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeDTO recipeDTO;

    @Autowired
    private RecipeRepository recipeRepository;

    @ModelAttribute("mealtypes")
    public List<String> mealType() {
        return recipeDTO.mealTypeDTO();
    }

    @ModelAttribute("timeofdays")
    public List<String> timeOfDay() {
        return recipeDTO.timeOfDayDTO();
    }

    @ModelAttribute("diets")
    public List<String> diets() {
        return recipeDTO.dietsDTO();
    }




    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addRecipeForm(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "/recipes/createRecipe";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveRecipe(@Valid Recipe recipe, BindingResult result) {
        if (result.hasErrors()) {
            return "/recipes/createRecipe";
        }
        recipe.setCreated(new Date());
        recipeRepository.save(recipe);
        return "redirect:/component/add/" + recipe.getId() ;
    }



}
