package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.RecipeDTO;
import pl.coderslab.model.QuantityComponent;
import pl.coderslab.model.Recipe;
import pl.coderslab.model.User;
import pl.coderslab.repository.QuantityComponentRepository;
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

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private QuantityComponentRepository quantityComponentRepository;

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
    public String addRecipeForm(Model model, @SessionAttribute String login) {
        User user  = userRepository.findByUserName(login);
        model.addAttribute("user", user);
        model.addAttribute("recipe", new Recipe());
        return "/recipes/createRecipe";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveRecipe(@Valid Recipe recipe,  BindingResult result, @SessionAttribute String login) {
        if (result.hasErrors()) {
            return "/recipes/createRecipe";
        }
        User user  = userRepository.findByUserName(login);
        recipe.setCreated(new Date());
        recipe.setUser(user);
        recipeRepository.save(recipe);
        return "redirect:/component/add/" + recipe.getId();
    }

    @RequestMapping(value = "/show/{id}")
    public String showRecipe(Model model, @PathVariable long id) {
        Recipe recipe = recipeRepository.findOne(id);
        List<QuantityComponent> quantityComponents = quantityComponentRepository.findAllByRecipeId(id);
        model.addAttribute("quantityComponents", quantityComponents);
        model.addAttribute("recipe", recipe);
        return "/recipes/showRecipe";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editRecipe(@PathVariable long id, Model model){
        Recipe recipe = recipeRepository.findOne(id);
        model.addAttribute("recipe", recipe);
        return "/recipes/createRecipe";
    }
    @RequestMapping(value = "/edit/{id}", method =  RequestMethod.POST)
    public String saveEditRecipe(@Valid Recipe recipe, BindingResult result) {
        if(result.hasErrors())
        {
            return "/recipes/createRecipe";
        }
        recipeRepository.save(recipe);
        return "redirect:/recipe/show/" + recipe.getId();
    }

    @RequestMapping(value = "/delete/{id}", method =  RequestMethod.GET)
    public String deleteRecipe(@PathVariable long id) {
        Recipe recipe = recipeRepository.findOne(id);
        recipeRepository.delete(recipe);
        return "redirect:/user/main";
    }

}
